package model.cliente;

public class PessoaJuridica extends Cliente{
  private String cnpj;
  public PessoaJuridica(String telefone, String nome, String endereco,String cnpj){
    super(telefone,nome, endereco);
    this.cnpj=cnpj;
  }
  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  
}
