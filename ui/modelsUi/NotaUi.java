package ui.modelsUi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import controller.ClienteController;
import controller.NotasController;
import controller.ProdutoController;
import model.cliente.Cliente;
import model.notas.ItemNota;
import model.product.Produto;
import model.notas.Nota;
import ui.InputUtils;

public class NotaUi {


  private NotasController notasController;
  private ProdutoController produtoController;
  private ClienteController clienteController;

  public NotaUi(NotasController notasController, ProdutoController produtoController, ClienteController clienteController) {
    this.notasController = notasController;
    this.produtoController=produtoController;
    this.clienteController=clienteController;
  }

  public void criarNotaDeCompra() {
    System.out.println("\n--- Criar Nota de Compra ---");

    // 1. Selecionar Cliente
    System.out.println("Clientes disponíveis:");
    clienteController.listarClientes();
    Long idCliente = InputUtils.lerLong("Digite o ID do cliente: ");
    Optional<Cliente> clienteOpt = clienteController.getClienteById(idCliente);
    if (clienteOpt.isEmpty()) {
      System.out.println("Cliente não encontrado!");
      return;
    }
    Cliente clienteSelecionado = clienteOpt.get();

    // 2. Adicionar Itens
    ItemNota[] itensNota = new ItemNota[100];
    int tamanhoAtualItensNota=0;
    String continuar;
    do {
      System.out.println("\nAdicionando item à nota...");
      produtoController.listarProdutos(); 
      Long idProduto = InputUtils.lerLong("Digite o ID do produto: ");
      Optional<Produto> produtoOpt = produtoController.buscarProdutoById(idProduto);

      if (produtoOpt.isEmpty()) {
        System.out.println("Produto não encontrado!");
        continuar = InputUtils.lerString("Deseja tentar adicionar outro item? (s/n): ");
        continue;
      }

      Produto produtoSelecionado = produtoOpt.get();
      int quantidade = InputUtils.lerInt("Digite a quantidade: ");

      if (produtoSelecionado.getQuantidadeEmEstoque() < quantidade) {
        System.out.println("Erro: Estoque insuficiente! Estoque atual: " +
                           produtoSelecionado.getQuantidadeEmEstoque());
      } else {
        ItemNota item = new ItemNota(produtoSelecionado, quantidade);
        if(tamanhoAtualItensNota == itensNota.length){
          ItemNota[] novoArrayItemNota = new ItemNota[tamanhoAtualItensNota*2];
          System.arraycopy(itensNota, 0 , novoArrayItemNota, 0, itensNota.length);
          itensNota = novoArrayItemNota;
        }
        itensNota[tamanhoAtualItensNota++]=item;
        System.out.println("Item adicionado!");
      }

      continuar = InputUtils.lerString("Adicionar outro item? (s/n): ");
    } while (continuar.equalsIgnoreCase("s"));

    if (Arrays.equals(itensNota, null)) {
      System.out.println("Nenhum item adicionado. Nota cancelada.");
      return;
    }

    // 3. Criar a nota
    Nota novaNota = notasController.criar(clienteSelecionado, itensNota);

    // 4. Exibir resumo
    System.out.println("\n--- NOTA CRIADA COM SUCESSO ---");
    System.out.println(novaNota);
    System.out.println("---------------------------------");
  }

  public void listarNotas() {
    System.out.println("\n--- Listando Notas Emitidas ---");
    notasController.listar();
  }

}
