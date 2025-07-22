package repository;
import java.util.Optional;

import model.cliente.Cliente;

public class ClienteRepository {
  private Cliente[] clientes= new Cliente[tamanhoAtual];
  private int tamanhoAtual=0;
  private static Long contador=1L;
  
  public void cadastraCliente(Cliente cliente){
    if(tamanhoAtual == clientes.length){
        Cliente[] novoArray = new Cliente[clientes.length + 10];
        System.arraycopy(clientes,0,novoArray,0,clientes.length);
        clientes = novoArray;
    }
    cliente.setId(contador++);
    clientes[tamanhoAtual++] = cliente;
  }

  public Cliente[] getClientes(){
    Cliente[] clientesAtuais = new Cliente[tamanhoAtual];
     System.arraycopy(clientes,0,clientesAtuais,0,clientes.length);
    return clientesAtuais;
  }
   public Optional<Cliente> buscarClientePorId(Long id) {
         for (int i = 0; i < tamanhoAtual; i++) {
        if (clientes[i].getId().equals(id)) {
            return Optional.of(clientes[i]);
        }
    }
    return Optional.empty();
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
}
