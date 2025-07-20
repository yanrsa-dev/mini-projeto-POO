package model.product;
import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
  
  private BigDecimal frete;
  private double distanciaEntreCompradorLoja;

  public ProdutoDigital(String nome, BigDecimal preco, int quantidadeEmEstoque, double distanciaEntreCompradorLoja){
    super(nome, preco,quantidadeEmEstoque);
    this.distanciaEntreCompradorLoja=distanciaEntreCompradorLoja;
    this.frete=calcularFrete(distanciaEntreCompradorLoja);
  }

  public BigDecimal calcularFrete(double distanciaEntreCompradorLoja){
    BigDecimal distancia = BigDecimal.valueOf(distanciaEntreCompradorLoja);
    BigDecimal acrecimo = BigDecimal.valueOf(0.5);
    BigDecimal resultado = distancia.multiply(acrecimo);
    frete = frete.add(resultado);
    return frete;
  }

  public BigDecimal getFrete() {
    return calcularFrete(distanciaEntreCompradorLoja);
  }

  public double getDistanciaEntreCompradorLoja() {
    return distanciaEntreCompradorLoja;
  }

  public void setDistanciaEntreCompradorLoja(double distanciaEntreCompradorLoja) {
    this.distanciaEntreCompradorLoja = distanciaEntreCompradorLoja;
  }

}
