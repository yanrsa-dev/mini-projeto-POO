 package controller;

import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import service.ClienteService;

import java.util.List;

public class ClienteController {

private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrarPessoaFisica(String endereco,String nome, String telefone, String cpf) {
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

        System.out.println("=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());

            if (cliente instanceof PessoaFisica) {
                System.out.println("CPF: " + ((PessoaFisica) cliente).getCpf());
                System.out.println("Tipo: Pessoa Física");
            } else if (cliente instanceof PessoaJuridica) {
                System.out.println("CNPJ: " + ((PessoaJuridica) cliente).getCnpj());
                System.out.println("Tipo: Pessoa Jurídica");
            }

            System.out.println("----------------------------");
        }
    }


}

