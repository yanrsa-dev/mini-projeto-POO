package view;

import view.modelsUi.ClienteUi;
import view.modelsUi.NotaUi;
import view.modelsUi.ProdutoUi;

public class ConsoleMenu {

  private ProdutoUi produtoUi;
  private NotaUi notaUi;
  private ClienteUi clienteUi;


  public ConsoleMenu(ProdutoUi produtoUi, NotaUi notaUi, ClienteUi clienteUi){
    this.produtoUi=produtoUi;
    this.notaUi=notaUi;
    this.clienteUi=clienteUi;
  }


  public void fluxoDeDados() {

    int opcao;
    do {
      exibirMenuPrincipal();
      opcao = InputUtils.lerInt("Escolha uma opção: ");

      switch (opcao) {
      case 1:
        produtoUi.cadastrarProduto();
        break;
      case 2:
        produtoUi.alterarProduto();
        break;
      case 3:
        clienteUi.cadastrarCliente();
        break;
      case 4:
        clienteUi.alterarCliente();
        break;
      case 5:
        notaUi.criarNotaDeCompra();
        break;
      case 6:
        notaUi.listarNotas();
        break;
      case 7:
        produtoUi.listarProdutos();
        break;
      case 8:
        clienteUi.listarClientes();
        break;
      case 0:
        System.out.println("Saindo do sistema...");
        break;
      default:
        System.out.println("Opção inválida!");
        break;
      }
    } while (opcao != 0);
  }

  private void exibirMenuPrincipal() {
    System.out.println("\n--- MENU PRINCIPAL ---");
    System.out.println("1. Cadastrar Produto");
    System.out.println("2. Alterar Produto");
    System.out.println("3. Cadastrar Cliente");
    System.out.println("4. Alterar Cliente");
    System.out.println("5. Criar Nota de Compra");
    System.out.println("6. Listar Notas Emitidas");
    System.out.println("7. Listar Produtos");
    System.out.println("8. Listar Clientes");
    System.out.println("0. Sair");
    System.out.println("----------------------");
  }

}
