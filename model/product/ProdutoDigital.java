package model.product;
import java.math.BigDecimal;

import enums.TiposProdutos;

public class ProdutoDigital extends Produto {
  
  private BigDecimal frete;
  private double distanciaEntreCompradorLoja;

  public ProdutoDigital(String nome, BigDecimal preco, int quantidadeEmEstoque, double distanciaEntreCompradorLoja){
    super(nome, preco,quantidadeEmEstoque);
    this.distanciaEntreCompradorLoja=distanciaEntreCompradorLoja;
    this.frete=calcularFrete();
  }

  public BigDecimal calcularFrete(){
    BigDecimal distancia = BigDecimal.valueOf(distanciaEntreCompradorLoja);
    BigDecimal fator = new BigDecimal("0.5");
    return distancia.multiply(fator);
  }

  public BigDecimal getFrete() {
    return frete;
  }

  public double getDistanciaEntreCompradorLoja() {
    return distanciaEntreCompradorLoja;
  }

  public void setDistanciaEntreCompradorLoja(double distanciaEntreCompradorLoja) {
    this.distanciaEntreCompradorLoja = distanciaEntreCompradorLoja;
    this.frete = this.calcularFrete();
  }

}
