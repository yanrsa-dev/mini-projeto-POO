package model.cliente;
import java.util.ArrayList;
import java.util.List;
/*• Cadastrar cliente com identificador único, nome, endereço e telefone.
• Listar clientes.
• Atualizar clientes.*/

public abstract class Cliente {

  private String telefone;
  private String nome;
  private String endereco;
  
  public Cliente(String telefone, String nome, String endereco) {
    this.telefone=telefone;
    this.nome = nome;
    this.endereco=endereco;
  }
   public String getTelefone() {
    return telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
    public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  //criando a lista de clientes
   private List<Cliente> clientes = new ArrayList<>();
  //cadastrando os clientes
  public CLiente cadastraCliente(String telefone,String nome, String endereco){
    Cliente cliente= new Cliente(telefone,nome,endereco);
    clientes.add(cliente);
    return cliente;
  }
  public List<Cliente> listarClientes() {
        return clientes;
    }
}

  

