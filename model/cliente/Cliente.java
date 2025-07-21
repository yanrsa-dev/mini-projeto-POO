package model.cliente;


public abstract class Cliente {
  private Long id;
  private String nome;
  private String endereco;
  private String telefone;

  public Cliente( String nome, String endereco,String telefone) {
    this.telefone = telefone;
    this.nome = nome;
    this.endereco = endereco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Override
  public String toString() {
    return String.format(
        "ID: %d | Nome: %s | Endereço: %s | Telefone: %s",
        getId(), getNome(), getEndereco(), getTelefone());
  }
}
