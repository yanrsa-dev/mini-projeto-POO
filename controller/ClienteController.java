import repository.ClienteRepository;
import service.ClienteService;

public class ClienteController {

  private ClienteService clienteService;
  private ClienteRepository clienteRepository;

  public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository){
    this.clienteService=clienteService;
    this.clienteRepository=clienteRepository;
  }

  public void criarPessoaFisica(Cliente novoCliente){
   clienteService.criarPessoaFisica(novoCliente.getTelefone(),novoCliente.getNome()
  , novoCliente.getEndereco(), novoCliente.getCpf(), novoCliente.get)
  }

    public void criarPessoaJuridica(Cliente novoCliente){
   clienteService.criarPessoaJuridica(novoCliente.getTelefone(),novoCliente.getNome()
  , novoCliente.getEndereco(), novoCliente.getCnpj(), novoCliente.get)
  }

}
