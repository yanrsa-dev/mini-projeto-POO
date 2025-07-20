 package ui.modelsUi;

import controller.ClienteController;
import model.cliente.*;
import repository.ClienteRepository;
import service.ClienteService;
import ui.InputUtils;

import java.util.List;
import java.util.Optional;

public class ClienteUi {

  private ClienteRepository clienteRepository;
  private ClienteService clienteService;
  private ClienteController clienteController;

  public ClienteUi(ClienteController clienteController, ClienteRepository clienteRepository, ClienteService clienteService) {
    this.clienteRepository = clienteRepository;
    this.clienteService = clienteService;
    this.clienteController = clienteController;
  }

  public void cadastrarCliente() {
    System.out.println("\n--- Cadastro de Cliente ---");
    int tipo = InputUtils.lerInt("Digite (1) para Pessoa Física ou (2) para Pessoa Jurídica: ");
    String nome = InputUtils.lerString("Nome: ");
    String endereco = InputUtils.lerString("Endereço: ");
    String telefone = InputUtils.lerString("Telefone: ");

    if (tipo == 1) {
      String cpf = InputUtils.lerCpf("CPF: ");
      clienteController.cadastrarPessoaFisica(nome, endereco, telefone, cpf);
    } else if (tipo == 2) {
      String cnpj = InputUtils.lerCnpj("CNPJ: ");
      clienteController.cadastrarPessoaJuridica(nome, endereco, telefone, cnpj);
    } else {
      System.out.println("Tipo de cliente inválido.");
      return;
    }
    System.out.println("Cliente cadastrado com sucesso!");
  }

  public void alterarCliente() {
    System.out.println("\n--- Alteração de Cliente ---");
    listarClientes();
    Long id = InputUtils.lerLong("Digite o ID do cliente que deseja alterar: ");

    Optional<Cliente> clienteOpt = clienteRepository.buscarClientePorId(id);
    if (clienteOpt.isEmpty()) {
      System.out.println("Cliente não encontrado com o ID informado.");
      return;
    }

    Cliente clienteAtual = clienteOpt.get();
    System.out.println("Dados atuais: Nome: " + clienteAtual.getNome() +
                       ", Endereço: " + clienteAtual.getEndereco() +
                       ", Telefone: " + clienteAtual.getTelefone());

    System.out.println("Digite os novos dados (deixe em branco para manter o valor atual):");

    String novoNome = InputUtils.lerString("Novo nome (" + clienteAtual.getNome() + "): ");
    if (novoNome.isBlank()) novoNome = clienteAtual.getNome();

    String novoEndereco = InputUtils.lerString("Novo endereço (" + clienteAtual.getEndereco() + "): ");
    if (novoEndereco.isBlank()) novoEndereco = clienteAtual.getEndereco();

    String novoTelefone = InputUtils.lerString("Novo telefone (" + clienteAtual.getTelefone() + "): ");
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

    clienteAtualizado.setId(id);

    boolean sucesso = clienteService.atualizarCliente(clienteAtualizado);

    if (sucesso) {
      System.out.println("Cliente atualizado com sucesso!");
    } else {
      System.out.println("Falha ao atualizar o cliente.");
    }
  }

  public void listarClientes() {
    System.out.println("\n--- Listando Clientes Cadastrados ---");
    List<Cliente> clientes = clienteService.listarClientes();
    if (clientes.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
      return;
    }
    for (Cliente c : clientes) {
      String tipoCliente = (c instanceof PessoaFisica) ? "Pessoa Física" : "Pessoa Jurídica";
      System.out.printf("ID: %d | Nome: %s | Telefone: %s | Tipo: %s%n",
                        c.getId(), c.getNome(), c.getTelefone(), tipoCliente);
    }
  }
}
