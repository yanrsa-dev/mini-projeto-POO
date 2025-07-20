package repository;
import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;

public class ClienteRepository {
  private List<Cliente> clientes = new ArrayList<>();
  
  public void cadastraCliente(Cliente cliente){
    clientes.add(cliente);
  }

  public List<Cliente> getClientes(){
    return clientes;
  }

}
