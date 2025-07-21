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

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Produto getProduto() {
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
    // String.format() é usado para criar uma string formatada e alinhada.
    // %-25s: Alinha o nome do produto à esquerda em um espaço de 25 caracteres.
    // Qtd: %2d: Formata a quantidade com 2 dígitos.
    // R$ %6.2f: Formata o preço e o subtotal com 2 casas decimais.
    return String.format("%-25s (Qtd: %2d x R$ %6.2f) ..... Subtotal: R$ %7.2f",
        this.produto.getNome(),
        this.getQuantidadeDeItens(),
        this.produto.getPreco(),
        this.calcularSubtotal());
  }

}
