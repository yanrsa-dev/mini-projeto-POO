package model.product;

import java.math.BigDecimal;

public class ProdutoDomesticos extends Produto {

  private String material;
  private String utilidade;

  public ProdutoDomesticos(String nome, BigDecimal preco,
                           int quantidadeEmEstoque, double peso, String marca,
                           String material, String utilidade) {
    super(nome, preco, quantidadeEmEstoque, peso, marca);
    this.material = material;
    this.utilidade = utilidade;
  }

  public String getMaterial() { return material; }

  public void setMaterial(String material) { this.material = material; }

  public void setUtilidade(String utilidade) { this.utilidade = utilidade; }

  public String getUtilidade() { return utilidade; }

  @Override
  public String toString() {
    String separador = "\n----------------------------------------";
    return String.format("--- PRODUTO DOMÉSTICO ---%s"
                             + "\n  CÓDIGO: %d"
                             + "\n  PRODUTO: %s"
                             + "\n  MARCA: %s"
                             + "\n  MATERIAL: %s"
                             + "\n  UTILIDADE: %s"
                             + "\n  Estoque: %d"
                             + "\n\n  PREÇO: R$ %.2f"
                             + "%s",
                         separador, getId(), getNome().toUpperCase(),
                         getMarca(), getMaterial(), getUtilidade(),
                         getQuantidadeEmEstoque(),
                         getPreco(), separador);
  }
}
