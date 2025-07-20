package model.product;
import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
  
  private BigDecimal frete;

  public ProdutoDigital(String nome, BigDecimal preco, int quantidadeEmEstoque, BigDecimal frete){
    super(nome, preco,quantidadeEmEstoque);
    this.frete=frete;
  }

  public BigDecimal getFrete() {
    return frete;
  }

  public void setFrete(BigDecimal frete) {
    this.frete = frete;
  }

}
