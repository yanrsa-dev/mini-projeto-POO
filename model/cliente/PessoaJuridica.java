package model.cliente;

public class PessoaJuridica extends Cliente {
  private String cnpj;

  public PessoaJuridica( String nome, String endereco,String telefone,String cnpj){
    super(nome, endereco,telefone);
    this.cnpj=cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    String infoComum = super.toString();

    return String.format("%s | Tipo: Pessoa Jurídica | CNPJ: %s", infoComum, getCnpj());
  }
}
