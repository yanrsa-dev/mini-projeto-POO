package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.cliente.Cliente;

public class ClienteRepository {
  private List<Cliente> clientes = new ArrayList<>();
  
  public void cadastraCliente(Cliente cliente){
    clientes.add(cliente);
  }

  public List<Cliente> getClientes(){
    return clientes;
  }
   public Optional<Cliente> buscarClientePorId(Long id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

}
public boolean atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == clienteAtualizado.getId()) {
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

