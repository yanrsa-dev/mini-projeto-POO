package model.product;
import java.math.BigDecimal;

public class ProdutoFisico extends Produto {

  private double peso;

  public ProdutoFisico(String nome , BigDecimal preco, int quantidadeEmEstoque, double peso){
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
