package service;

import model.cliente.Cliente;
import repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
      this.clienteRepository=clienteRepository;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.cadastraCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.getClientes();
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.buscarClientePorId(id);
        return clienteOptional.orElse(null);
    }

    public boolean atualizarCliente(Cliente clienteAtualizado) {
        return clienteRepository.atualizarCliente(clienteAtualizado);
    }
}
