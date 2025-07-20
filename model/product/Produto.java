package model.product;

import java.math.BigDecimal;

public abstract class Produto {

  private Long id;
  private String nome;
  private BigDecimal preco;
  private int quantidadeEmEstoque;


  public Produto(String nome, BigDecimal preco, int quantidadeEmEstoque) {
    this.nome = nome;
    this.preco = preco;
    this.quantidadeEmEstoque=quantidadeEmEstoque;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getNome() {
    return nome;
  }


  public void setNome(String nome) {
    this.nome = nome;
  }


  public BigDecimal getPreco() {
    return preco;
  }


  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }


  public int getQuantidadeEmEstoque() {
    return quantidadeEmEstoque;
  }


  public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
    this.quantidadeEmEstoque = quantidadeEmEstoque;
  }


  @Override
  public String toString() {
    return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidadeEmEstoque=" + quantidadeEmEstoque
        + "]";
  }



}
