package model.product;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoPericivel extends Produto {

  private LocalDate validade;

  public ProdutoPericivel(String nome, BigDecimal preco, int quantidadeEmEstoque, LocalDate validade) {
    super(nome, preco, quantidadeEmEstoque);
    this.validade = validade;
  }

  public LocalDate getValidade() {
    return validade;
  }

  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }

}
