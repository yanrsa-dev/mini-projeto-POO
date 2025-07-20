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

    public void cadastrarPessoaFisica(,String endereco,String nome, String telefone, String cpf) {
        PessoaFisica pf = new PessoaFisica(nome, endereco, telefone, cpf);
        clienteService.cadastrarCliente(pf);
    }
   public void cadastrarPessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
        PessoaJuridica pj = new PessoaJuridica(nome, endereco, telefone, cnpj);
        clienteService.cadastrarCliente(pj);
    }


}

