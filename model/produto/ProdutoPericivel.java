import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoPericivel extends Produto {

  private LocalDateTime validade;

  public ProdutoPericivel(String nome, BigDecimal preco, int quantidadeEmEstoque, LocalDateTime validade) {
    super(nome, preco, quantidadeEmEstoque);
    this.validade = validade;
  }

  public LocalDateTime getValidade() {
    return validade;
  }

  public void setValidade(LocalDateTime validade) {
    this.validade = validade;
  }

}
