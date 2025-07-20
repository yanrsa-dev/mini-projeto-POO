 package controller;

import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import service.ClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteController {

private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrarPessoaFisica(String nome,String endereco, String telefone, String cpf) {
        PessoaFisica pf = new PessoaFisica(nome, endereco, telefone, cpf);
        clienteService.cadastrarCliente(pf);
    }
   public void cadastrarPessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
        PessoaJuridica pj = new PessoaJuridica(nome, endereco, telefone, cnpj);
        clienteService.cadastrarCliente(pj);
    }
   public void listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
          System.out.println(cliente);
        }
    }

   public Optional<Cliente> getClienteById(Long id){
     return Optional.ofNullable(clienteService.buscarClientePorId(id));
   }


}

