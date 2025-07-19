package model.cliente;

public class PessoaFisica extends Cliente{
  private String cpf;
  public PessoaFisica(String telefone, String nome, String endereco,String cpf){
    super(telefone,nome, endereco,cpf);
    this.cpf=cpf;
  }
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  
}
