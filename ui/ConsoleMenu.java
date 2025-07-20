// Coloque esta classe no mesmo pacote que a InputUtils.
package ui;

import controller.ClienteController;
import controller.NotasController;
import controller.ProdutoController;
import enums.TiposProdutos;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import model.notas.ItemNota;
import model.notas.Nota;
import model.product.Produto;
import model.product.ProdutoFisico;
import repository.ClienteRepository;
import repository.NotasRepository;
import repository.ProdutoRepository;
import service.ClienteService;
import service.NotasService;
import service.ProdutoService;

public class ConsoleMenu {

  // Repositórios
  private static final ClienteRepository clienteRepository = new ClienteRepository();
  private static final ProdutoRepository produtoRepository = new ProdutoRepository();
  private static final NotasRepository notasRepository = new NotasRepository();

  // Serviços
  private static final ClienteService clienteService = new ClienteService();
  private static final ProdutoService produtoService = new ProdutoService(produtoRepository);
  private static final NotasService notasService = new NotasService(notasRepository);

  // Controllers
  private static final ClienteController clienteController = new ClienteController(clienteService);
  private static final NotasController notasController = new NotasController(notasService);
  private static final ProdutoController produtoController = new ProdutoController(produtoService);

  public void fluxoDeDados() {
    // Pré-cadastrar alguns dados para facilitar os testes
    popularDadosIniciais();

    int opcao;
    do {
      exibirMenuPrincipal();
      opcao = InputUtils.lerInt("Escolha uma opção: ");

      switch (opcao) {
        case 1:
          cadastrarProduto();
          break;
        case 2:
          alterarProduto();
          break;
        case 3:
          cadastrarCliente();
          break;
        case 4:
          alterarCliente();
          break;
        case 5:
          criarNotaDeCompra();
          break;
        case 6:
          listarNotas();
          break;
        case 7:
          listarProdutos();
          break;
        case 8:
          listarClientes();
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

  private static void exibirMenuPrincipal() {
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

  private static void cadastrarProduto() {
    System.out.println("\n--- Cadastro de Produto ---");
    String nome = InputUtils.lerString("Nome: ");
    BigDecimal preco = InputUtils.lerBigDecimal("Preço: ");
    int qtdEstoque = InputUtils.lerInt("Quantidade em Estoque: ");
    double peso = InputUtils.lerDouble("Peso (kg): ");

    // Listar e escolher TiposProdutos
    System.out.println("Tipos de Produto disponíveis:");
    for (TiposProdutos tipo : TiposProdutos.values()) {
      System.out.println("- " + tipo.name());
    }
    TiposProdutos tipoProduto =
        TiposProdutos.valueOf(InputUtils.lerString("Digite o tipo do produto: ").toUpperCase());

    if (tipoProduto.perecivel()) {
      LocalDate validade = InputUtils.lerLocalDate("Data de Validade");
      produtoService.criarProdutoFisicoPericivel(
          nome, preco, qtdEstoque, peso, tipoProduto, validade);
    } else {
      produtoService.criarProdutoFisicoNaoPericivel(nome, preco, qtdEstoque, peso, tipoProduto);
    }
    System.out.println("Produto cadastrado com sucesso!");
  }

  private static void cadastrarCliente() {
    System.out.println("\n--- Cadastro de Cliente ---");
    int tipo = InputUtils.lerInt("Digite (1) para Pessoa Física ou (2) para Pessoa Jurídica: ");
    String nome = InputUtils.lerString("Nome: ");
    String endereco = InputUtils.lerString("Endereço: ");
    String telefone = InputUtils.lerString("Telefone: ");

    if (tipo == 1) {
      String cpf = InputUtils.lerString("CPF: ");
      clienteController.cadastrarPessoaFisica(nome, endereco, telefone, cpf);
    } else if (tipo == 2) {
      String cnpj = InputUtils.lerString("CNPJ: ");
      clienteController.cadastrarPessoaJuridica(nome, endereco, telefone, cnpj);
    } else {
      System.out.println("Tipo de cliente inválido.");
      return;
    }
    System.out.println("Cliente cadastrado com sucesso!");
  }

  private static void criarNotaDeCompra() {
    System.out.println("\n--- Criar Nota de Compra ---");

    // 1. Selecionar Cliente
    System.out.println("Clientes disponíveis:");
    listarClientes();
    Long idCliente = InputUtils.lerLong("Digite o ID do cliente: ");
    Optional<Cliente> clienteOpt = clienteRepository.buscarClientePorId(idCliente);
    if (clienteOpt.isEmpty()) {
      System.out.println("Cliente não encontrado!");
      return;
    }
    Cliente clienteSelecionado = clienteOpt.get();

    // 2. Adicionar Itens
    List<ItemNota> itensNota = new ArrayList<>();
    String continuar;
    do {
      System.out.println("\nAdicionando item à nota...");
      listarProdutos();
      Long idProduto = InputUtils.lerLong("Digite o ID do produto: ");
      Optional<Produto> produtoOpt = produtoRepository.getProdutoById(idProduto);

      if (produtoOpt.isEmpty()) {
        System.out.println("Produto não encontrado!");
        continuar = InputUtils.lerString("Deseja tentar adicionar outro item? (s/n): ");
        continue;
      }
      Produto produtoSelecionado = produtoOpt.get();
      int quantidade = InputUtils.lerInt("Digite a quantidade: ");

      // Aqui, o serviço validaria o estoque antes de continuar
      if (produtoSelecionado.getQuantidadeEmEstoque() < quantidade) {
        System.out.println(
            "Erro: Estoque insuficiente! Estoque atual: "
                + produtoSelecionado.getQuantidadeEmEstoque());
      } else {
        ItemNota item = new ItemNota(produtoSelecionado, quantidade);
        itensNota.add(item);
        System.out.println("Item adicionado!");
      }

      continuar = InputUtils.lerString("Adicionar outro item? (s/n): ");
    } while (continuar.equalsIgnoreCase("s"));

    if (itensNota.isEmpty()) {
      System.out.println("Nenhum item adicionado. Nota cancelada.");
      return;
    }

    // 3. Criar a nota através do serviço (que cuidará do estoque)
    Nota novaNota = notasService.criarNota(clienteSelecionado, itensNota);

    // 4. Exibir resumo
    System.out.println("\n--- NOTA CRIADA COM SUCESSO ---");
    System.out.println(novaNota);
    System.out.println("---------------------------------");
  }

  private static void listarNotas() {
    System.out.println("\n--- Listando Notas Emitidas ---");
    notasController.listar();
  }

  private static void listarProdutos() {
    System.out.println("\n--- Listando Produtos em Estoque ---");
    produtoController.listarProdutos();
  }

  private static void listarClientes() {
    System.out.println("\n--- Listando Clientes Cadastrados ---");
    List<Cliente> clientes = clienteService.listarClientes();
    if (clientes.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
      return;
    }
    for (Cliente c : clientes) {
      String tipoCliente = (c instanceof PessoaFisica) ? "Pessoa Física" : "Pessoa Jurídica";
      System.out.printf(
          "ID: %d | Nome: %s | Telefone: %s | Tipo: %s%n",
          c.getId(), c.getNome(), c.getTelefone(), tipoCliente);
    }
  }

  private static void popularDadosIniciais() {
    // Clientes
    clienteController.cadastrarPessoaFisica(
        "João da Silva", "Rua A, 123",
        "79999998888", "111.222.333-44");
    clienteController.cadastrarPessoaJuridica(
        "Mercado Pague Menos", "Av. B, 456", "7932224444", "12.345.678/0001-99");

    // Produtos
    produtoService.criarProdutoFisicoNaoPericivel(
        "Sabão em Pó", new BigDecimal("15.50"), 100, 1.0, TiposProdutos.PRODUTOS_DE_LIMPEZA);
    produtoService.criarProdutoFisicoNaoPericivel(
        "Caderno 10 Matérias", new BigDecimal("25.00"), 50, 0.8, TiposProdutos.PAPELARIA);
    produtoService.criarProdutoFisicoPericivel(
        "Iogurte Natural",
        new BigDecimal("5.50"),
        80,
        0.2,
        TiposProdutos.LATICINIOS,
        LocalDate.of(2025, 8, 20));
  }

  private static void alterarProduto() {
    System.out.println("\n--- Alteração de Produto ---");
    listarProdutos();
    Long id = InputUtils.lerLong("Digite o ID do produto que deseja alterar: ");

    Optional<Produto> produtoOpt = produtoRepository.getProdutoById(id);
    if (produtoOpt.isEmpty() || !(produtoOpt.get() instanceof ProdutoFisico)) {
      System.out.println("Produto físico não encontrado com o ID informado.");
      return;
    }

    ProdutoFisico produtoAtual = (ProdutoFisico) produtoOpt.get();
    System.out.println("Dados atuais: " + produtoAtual);

    System.out.println("Digite os novos dados (deixe em branco para manter o valor atual):");

    String novoNome = InputUtils.lerString("Novo nome (" + produtoAtual.getNome() + "): ");
    if (novoNome.isBlank()) novoNome = produtoAtual.getNome();

    String precoStr = InputUtils.lerString("Novo preço (" + produtoAtual.getPreco() + "): ");
    BigDecimal novoPreco = precoStr.isBlank() ? produtoAtual.getPreco() : new BigDecimal(precoStr);

    String estoqueStr =
        InputUtils.lerString(
            "Nova quantidade em estoque (" + produtoAtual.getQuantidadeEmEstoque() + "): ");
    int novoEstoque =
        estoqueStr.isBlank() ? produtoAtual.getQuantidadeEmEstoque() : Integer.parseInt(estoqueStr);

    String pesoStr = InputUtils.lerString("Novo peso (" + produtoAtual.getPeso() + "): ");
    double novoPeso = pesoStr.isBlank() ? produtoAtual.getPeso() : Double.parseDouble(pesoStr);

    // Criando um novo objeto com os dados atualizados para passar ao
    // serviço/controller
    // O construtor de ProdutoFisico precisa ser o que aceita todos os campos.
    ProdutoFisico produtoAtualizado;
    if (produtoAtual.getTiposProdutos().perecivel()) {
      String validadeStr =
          InputUtils.lerString("Nova data de validade (" + produtoAtual.getValidade() + "): ");
      LocalDate novaValidade =
          validadeStr.isBlank()
              ? produtoAtual.getValidade()
              : LocalDate.parse(
                  validadeStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      produtoAtualizado =
          new ProdutoFisico(
              novoNome,
              novoPreco,
              novoEstoque,
              novoPeso,
              produtoAtual.getTiposProdutos(),
              novaValidade);
    } else {
      produtoAtualizado =
          new ProdutoFisico(
              novoNome, novoPreco, novoEstoque, novoPeso, produtoAtual.getTiposProdutos());
    }

    // Chamando o método do controller para efetivar a atualização
    produtoController.atualizarProdutoFisico(produtoAtualizado, id);
    System.out.println("Produto atualizado com sucesso!");
  }

  private static void alterarCliente() {
    System.out.println("\n--- Alteração de Cliente ---");
    listarClientes();
    Long id = InputUtils.lerLong("Digite o ID do cliente que deseja alterar: ");

    Optional<Cliente> clienteOpt = clienteRepository.buscarClientePorId(id);
    if (clienteOpt.isEmpty()) {
      System.out.println("Cliente não encontrado com o ID informado.");
      return;
    }

    Cliente clienteAtual = clienteOpt.get();
    System.out.println(
        "Dados atuais: Nome: "
            + clienteAtual.getNome()
            + ", Endereço: "
            + clienteAtual.getEndereco()
            + ", Telefone: "
            + clienteAtual.getTelefone());

    System.out.println("Digite os novos dados (deixe em branco para manter o valor atual):");

    String novoNome = InputUtils.lerString("Novo nome (" + clienteAtual.getNome() + "): ");
    if (novoNome.isBlank()) novoNome = clienteAtual.getNome();

    String novoEndereco =
        InputUtils.lerString("Novo endereço (" + clienteAtual.getEndereco() + "): ");
    if (novoEndereco.isBlank()) novoEndereco = clienteAtual.getEndereco();

    String novoTelefone =
        InputUtils.lerString("Novo telefone (" + clienteAtual.getTelefone() + "): ");
    if (novoTelefone.isBlank()) novoTelefone = clienteAtual.getTelefone();

    Cliente clienteAtualizado;
    if (clienteAtual instanceof PessoaFisica pf) {
      String novoCpf = InputUtils.lerString("Novo CPF (" + pf.getCpf() + "): ");
      if (novoCpf.isBlank()) novoCpf = pf.getCpf();
      clienteAtualizado = new PessoaFisica(novoNome, novoEndereco, novoTelefone, novoCpf);
    } else if (clienteAtual instanceof PessoaJuridica pj) {
      String novoCnpj = InputUtils.lerString("Novo CNPJ (" + pj.getCnpj() + "): ");
      if (novoCnpj.isBlank()) novoCnpj = pj.getCnpj();
      clienteAtualizado = new PessoaJuridica(novoNome, novoEndereco, novoTelefone, novoCnpj);
    } else {
      System.out.println("Tipo de cliente desconhecido. A atualização não pode continuar.");
      return;
    }

    // O método de atualização precisa do ID para encontrar o cliente a ser
    // atualizado.
    clienteAtualizado.setId(id);

    // Usando o método do serviço diretamente, conforme disponível
    boolean sucesso = clienteService.atualizarCliente(clienteAtualizado);

    if (sucesso) {
      System.out.println("Cliente atualizado com sucesso!");
    } else {
      System.out.println("Falha ao atualizar o cliente.");
    }
  }
}
