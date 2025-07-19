package model.cliente;

public class PessoaFisica extends Cliente{
  private String cpf;

  public PessoaFisica(){
    super(nome,preco, quantidadeEmEstoque);
    this.peso=peso;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  
}
