package service;

import model.cliente.Cliente;
import repository.ClienteRepository;
import java.util.List;

public class ClienteService {
   private ClienteRepository repository = new ClienteRepository();

    public void cadastrarCliente(Cliente cliente) {
        repository.cadastrarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.getClientes();
    }

    public Cliente buscarClientePorId(Long id) {
        return repository.buscarClientePorId(id);
    }

    public boolean atualizarCliente(Cliente clienteAtualizado) {
        return repository.atualizarCliente(clienteAtualizado);
    }
}
