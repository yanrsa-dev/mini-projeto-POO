package model.product;

import java.math.BigDecimal;

public abstract class Produto {

  private static Long idContador=1L;
  private Long id;
  private String nome;
  private BigDecimal preco;
  private int quantidadeEmEstoque;


  public Produto(String nome, BigDecimal preco, int quantidadeEmEstoque) {
    this.nome = nome;
    this.preco = preco;
    this.quantidadeEmEstoque=quantidadeEmEstoque;
    this.id=idContador++;
  }


  public static Long getIdContador() {
    return idContador;
  }


  public static void setIdContador(Long idContador) {
    Produto.idContador = idContador;
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



}
