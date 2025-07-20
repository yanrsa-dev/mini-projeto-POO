package model.cliente;


/*• Cadastrar cliente com identificador único, nome, endereço e telefone.
• Listar clientes.
• Atualizar clientes.*/

public abstract class Cliente {
  private static Long idContador=1L;
  private Long id;
  private String telefone;
  private String nome;
  private String endereco;

  public Cliente(String telefone, String nome, String endereco) {
    this.id=idContador++;
    this.telefone = telefone;
    this.nome = nome;
    this.endereco = endereco;
  }
  public static Long getIdContador(){
    return idContador;
  }
    public static void setIdContador(Long idContador) {
    Cliente.idContador = idContador;
  }

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id=id;
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
}
