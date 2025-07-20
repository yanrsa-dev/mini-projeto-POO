package model.product;
import java.math.BigDecimal;
import java.time.LocalDate;
import enums.TiposProdutos;

public class ProdutoFisico extends Produto {

  private double peso;
  private TiposProdutos tiposProdutos;
  private LocalDate validade;


  public ProdutoFisico(String nome , BigDecimal preco, int quantidadeEmEstoque, double peso, TiposProdutos tiposProdutos){
    super(nome,preco, quantidadeEmEstoque);
    this.peso=peso;
    this.tiposProdutos=tiposProdutos;
  }

  public ProdutoFisico(String nome , BigDecimal preco, int quantidadeEmEstoque, double peso, TiposProdutos tiposProdutos, LocalDate validade){
    super(nome,preco, quantidadeEmEstoque);
    this.peso=peso;
    this.tiposProdutos=tiposProdutos;
    this.validade=validade;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

}
