package model.notas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.product.Produto;

public class ItemNota {

  private Produto produto;
  private int quantidadeDeItens;

  public ItemNota(Produto produto, int quantidadeDeItens) {
    this.produto = produto;
    this.quantidadeDeItens = quantidadeDeItens;
  }

  public BigDecimal calcularSubtotal() {
    return produto.getPreco().multiply(BigDecimal.valueOf(quantidadeDeItens));
  }

  public void setProduto(Produto produto){
    this.produto=produto;
  }

  public Produto getProduto(){
    return produto;
  }

  public int getQuantidadeDeItens() {
    return quantidadeDeItens;
  }

  public void setQuantidadeDeItens(int quantidadeDeItens) {
    this.quantidadeDeItens = quantidadeDeItens;
  }

  @Override
  public String toString() {
    return "ItemNota [produto=" + produto + ", quantidadeDeItens=" + quantidadeDeItens + ", calcularSubtotal()="
        + calcularSubtotal() + "]";
  }

}
