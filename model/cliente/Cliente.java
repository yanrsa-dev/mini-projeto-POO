package model.cliente;
/*• Cadastrar cliente com identificador único, nome, endereço e telefone.
• Listar clientes.
• Atualizar clientes.*/

public abstract class Cliente {

  private String telefone;
  private String cpf_cnpj;
  private String nome;
  private String endereco;
  
  public Cliente(String telefone, String cpf_cnpj, String nome, String endereco;) {
    this.telefone=telefone;
    this.cpf_cnpj=cpf_cnpj;
    this.nome = nome;
    this.endereco=endereco;
  }
   public String getTelefone() {
    return telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
    public String getCpf_cnpj() {
    return cpf_cnpj;
  }
  public void setCpf_cnpj(String cpf_cnpj) {
    this.cpf_cnpj = cpf_cnpj;
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

  

