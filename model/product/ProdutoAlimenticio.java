package model.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {

  private LocalDate validade;

  public ProdutoAlimenticio(
      String nome,
      BigDecimal preco,
      int quantidadeEmEstoque,
      double peso,
      String marca,
      LocalDate validade) {
    super(nome, preco, quantidadeEmEstoque, peso, marca);
    this.validade = validade;
  }

  public LocalDate getValidade() {
    return validade;
  }

  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }

  @Override
  public String toString() {
    String separador = "\n----------------------------------------";
    String alertaVencimento = "";
    if (getValidade().isBefore(java.time.LocalDate.now().plusDays(7))) {
      alertaVencimento = "\n  ATENÇÃO: VENCIMENTO PRÓXIMO!";
    }

    return String.format(
        "--- PRODUTO ALIMENTÍCIO ---%s"
            + "\n  CÓDIGO: %d"
            + "\n  PRODUTO: %s"
            + "\n  MARCA: %s"
            + "\n  PESO: %.3f kg"
            + "\n\n  PREÇO: R$ %.2f"
            + "\n\n  Estoque: %d"
            + "\n\n  CONSUMIR ATÉ: %s"
            + "%s"
            + "%s",
        separador,
        getId(),
        getNome().toUpperCase(),
        getMarca(),
        getPeso(),
        getPreco(),
        getQuantidadeEmEstoque(),
        getValidade().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
        alertaVencimento,
        separador);
  }
}
