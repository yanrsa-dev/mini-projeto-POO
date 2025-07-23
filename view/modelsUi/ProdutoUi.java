package view.modelsUi;

import java.math.BigDecimal;
import java.time.LocalDate;

import controller.ProdutoController;
import model.product.Produto;
import model.product.ProdutoAlimenticio;
import model.product.ProdutoEletronico;
import model.product.ProdutoDomesticos;
import view.InputUtils;


public class ProdutoUi {

  private ProdutoController produtoController;


  public ProdutoUi(ProdutoController produtoController) {
    this.produtoController = produtoController;
  }

  public void cadastrarProduto() {
    System.out.println("\n--- Cadastro de Produto ---");
    System.out.println("Qual tipo de produto deseja cadastrar?");
    System.out.println("1. Produto Alimentício");
    System.out.println("2. Produto Eletrônico");
    System.out.println("3. Produto Doméstico");
    int tipo = InputUtils.lerInt("Escolha o tipo: ");

    String nome = InputUtils.lerString("Nome: ");
    BigDecimal preco = InputUtils.lerBigDecimal("Preço: ");
    int qtdEstoque = InputUtils.lerInt("Quantidade em Estoque: ");
    double peso = InputUtils.lerDouble("Peso (kg): ");
    String marca = InputUtils.lerString("Marca: ");

    switch (tipo) {
      case 1:
        System.out.println("\nDigite os dados específicos para Produto Alimentício:");
        LocalDate validade = InputUtils.lerLocalDate("Data de Validade");
        produtoController.criarProdutoAlimenticio(nome, preco, qtdEstoque, peso, marca, validade);
        break;
      case 2:
        System.out.println("\nDigite os dados específicos para Produto Eletrônico:");
        int voltagem = InputUtils.lerInt("Voltagem (V): ");
        LocalDate garantia = InputUtils.lerLocalDate("Data final da Garantia");
        produtoController.criarProdutoEletronico(
            nome, preco, qtdEstoque, peso, marca, voltagem, garantia);
        break;
      case 3:
        System.out.println("\nDigite os dados específicos para Produto Doméstico:");
        String material = InputUtils.lerString("Material principal: ");
        String utilidade = InputUtils.lerString("Utilidade principal: ");
        produtoController.criarProdutosDomesticos(
            nome, preco, qtdEstoque, peso, marca, material, utilidade);
        break;
      default:
        System.out.println("Tipo de produto inválido. Operação cancelada.");
        return;
    }
    System.out.println("Produto cadastrado com sucesso!");
  }

  public void alterarProduto() {
    System.out.println("\n--- Alteração de Produto ---");
    produtoController.listarProdutos();
    Long id = InputUtils.lerLong("Digite o ID do produto que deseja alterar: ");

    Produto produtoAtual = produtoController.buscarProdutoById(id).orElse(null);

    if (produtoAtual == null) {
      System.out.println("Produto não encontrado com o ID informado.");
      return;
    }

    System.out.println("Produto selecionado: " + produtoAtual.getNome());
    System.out.println("Digite os novos dados (deixe em branco para manter o valor atual):");

    if (produtoAtual instanceof ProdutoAlimenticio pa) {
      alterarProdutoAlimenticio(id, pa);
    } else if (produtoAtual instanceof ProdutoEletronico pe) {
      alterarProdutoEletronico(id, pe);
    } else if (produtoAtual instanceof ProdutoDomesticos pd) {
      alterarProdutosDomesticos(id, pd);
    } else {
      System.out.println("Tipo de produto não suportado para alteração.");
    }
  }

  public void alterarProdutoAlimenticio(Long id, ProdutoAlimenticio produtoAtual) {
    String nome = InputUtils.lerString("Novo nome (" + produtoAtual.getNome() + "): ");
    BigDecimal preco = InputUtils.lerBigDecimal("Novo preço (" + produtoAtual.getPreco() + "): ");

    double peso = InputUtils.lerDouble("Novo peso (" + produtoAtual.getPeso() + "): ");

    String marca = InputUtils.lerString("Nova marca (" + produtoAtual.getMarca() + "): ");

    int quantidadeEmEstoque =
        InputUtils.lerInt(
            "Nova quantidade em estoque (" + produtoAtual.getQuantidadeEmEstoque() + "): ");

    LocalDate validade =
        InputUtils.lerLocalDate("Nova data de validade (" + produtoAtual.getValidade() + ")");

    ProdutoAlimenticio produtoAtualizado =
        new ProdutoAlimenticio(
            nome.isBlank() ? produtoAtual.getNome() : nome,
            preco,
            quantidadeEmEstoque,
            peso,
            marca,
            validade);

    produtoController.atualizarProduto(id, produtoAtualizado);
    System.out.println("Produto alimentício atualizado com sucesso!");
  }

  public void alterarProdutoEletronico(Long id, ProdutoEletronico produtoAtual) {
    String nome = InputUtils.lerString("Novo nome (" + produtoAtual.getNome() + "): ");
    BigDecimal preco = InputUtils.lerBigDecimal("Novo preço (" + produtoAtual.getPreco() + "): ");

    double peso = InputUtils.lerDouble("Novo peso (" + produtoAtual.getPeso() + "): ");

    String marca = InputUtils.lerString("Nova marca (" + produtoAtual.getMarca() + "): ");

    int voltagem = InputUtils.lerInt("Nova voltagem (" + produtoAtual.getVoltagem() + "): ");

    int quantidadeEmEstoque =
        InputUtils.lerInt(
            "Nova quantidade em estoque (" + produtoAtual.getQuantidadeEmEstoque() + "): ");

    LocalDate garantia =
        InputUtils.lerLocalDate("Nova data de garantia (" + produtoAtual.getGarantia() + ")");

    ProdutoEletronico produtoEletronico =
        new ProdutoEletronico(
            nome.isBlank() ? produtoAtual.getNome() : nome,
            preco,
            quantidadeEmEstoque,
            peso,
            marca,
            voltagem,
            garantia);

    produtoController.atualizarProduto(id, produtoEletronico);
    System.out.println("Produto eletronico atualizado com sucesso!");
  }

  public void alterarProdutosDomesticos(Long id, ProdutoDomesticos produtoAtual) {
    String nome = InputUtils.lerString("Novo nome (" + produtoAtual.getNome() + "): ");
    BigDecimal preco = InputUtils.lerBigDecimal("Novo preço (" + produtoAtual.getPreco() + "): ");

    double peso = InputUtils.lerDouble("Novo peso (" + produtoAtual.getPeso() + "): ");

    String marca = InputUtils.lerString("Nova marca (" + produtoAtual.getMarca() + "): ");

    int quantidadeEmEstoque =
        InputUtils.lerInt(
            "Nova quantidade em estoque (" + produtoAtual.getQuantidadeEmEstoque() + "): ");

    String material = InputUtils.lerString("Novo material (" + produtoAtual.getMaterial() + "): ");
    String utilidade =
        InputUtils.lerString("Nova utilidade (" + produtoAtual.getUtilidade() + "): ");

    ProdutoDomesticos produtoDomesticos =
        new ProdutoDomesticos(nome, preco, quantidadeEmEstoque, peso, marca, material, utilidade);

    produtoController.atualizarProduto(id, produtoDomesticos);
    System.out.println("Produto domestico atualizado com sucesso!");
  }

  public void listarProdutos() {
    System.out.println("\n--- Listando Produtos em Estoque ---");
    produtoController.listarProdutos();
  }
}
