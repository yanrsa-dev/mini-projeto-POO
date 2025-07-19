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

  public String getnome() {
    return nome;
  }
  public void setnome(String nome) {
    this.nome = nome;
  }
  public BigDecimal getpreco() {
    return preco;
  }
  public void setpreco(BigDecimal preco) {
    this.preco = preco;
  }
  public void setQuantidadeEmEstoque(int quantidadeEmEstoque){
    this.quantidadeEmEstoque=quantidadeEmEstoque;
  }
  public int getQuantidadeEmEstoque(){ return quantidadeEmEstoque;}

}
