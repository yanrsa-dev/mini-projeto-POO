package repository;
import java.util.Arrays;
import java.util.Optional;

import model.cliente.Cliente;

public class ClienteRepository {
  private Cliente[] clientes= new Cliente[10];
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
    return Arrays.copyOf(clientes, tamanhoAtual);
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
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getId() == clienteAtualizado.getId()) {
                clientes[i].setId(clienteAtualizado.getId());
                clientes[i] = clienteAtualizado;
                return true;
            }
        }
        return false;
}
}
