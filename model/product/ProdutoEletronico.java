package model.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoEletronico extends Produto {

  private int voltagem;
  private LocalDate garantia;

  public ProdutoEletronico(String nome, BigDecimal preco,
                           int quantidadeEmEstoque, double peso, String marca,
                           int voltagem, LocalDate garantia) {
    super(nome, preco, quantidadeEmEstoque, peso, marca);
    this.voltagem = voltagem;
    this.garantia = garantia;
  }

  public int getVoltagem() { return voltagem; }

  public void setVoltagem(int voltagem) { this.voltagem = voltagem; }

  public LocalDate getGarantia() { return garantia; }

  public void setGarantia(LocalDate garantia) { this.garantia = garantia; }

  @Override
  public String toString() {
    String separador = "\n----------------------------------------";
    return String.format(
        "--- PRODUTO ELETRÔNICO ---%s"
            + "\n  CÓDIGO: %d"
            + "\n  PRODUTO: %s"
            + "\n  MARCA: %s"
            + "\n  Estoque: %d"
            + "\n  VOLTAGEM: %d V"
            + "\n  GARANTIA: Até %s"
            + "\n\n  PREÇO: R$ %.2f"
            + "%s",
        separador,
        getId(), 
        getNome().toUpperCase(), getMarca(), getQuantidadeEmEstoque(),
        getVoltagem(),
        getGarantia().format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
        getPreco(), separador);
  }
}
