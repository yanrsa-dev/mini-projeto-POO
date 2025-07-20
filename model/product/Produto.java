package model.product;

import java.math.BigDecimal;

public abstract class Produto {

  private Long id;
  private String nome;
  private BigDecimal preco;
  private int quantidadeEmEstoque;
  private double peso;
  private String marca;


  public Produto(String nome, BigDecimal preco, int quantidadeEmEstoque, double peso, String marca) {
    this.nome = nome;
    this.preco = preco;
    this.quantidadeEmEstoque=quantidadeEmEstoque;
    this.peso=peso;
    this.marca=marca;
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

  public void setPeso(double peso){
    this.peso=peso;
  }

  public double getPeso(){
    return peso;
  }

  public void setMarca(String marca){
    this.marca=marca;
  }

  public String getMarca(){
    return marca;
  }



  @Override
  public String toString() {
    return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidadeEmEstoque=" + quantidadeEmEstoque
        + "]";
  }



}
