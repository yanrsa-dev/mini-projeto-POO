package model.notas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.cliente.Cliente;

public class Nota {

  private Cliente cliente;
  private ItemNota[] listaItemNota = new ItemNota[10];
  private int tamanhoAtual = 0;
  private Long id;
  private LocalDateTime data;

  public Nota(Cliente cliente, ItemNota[] listaItemNota) {
    this.cliente = cliente;
    this.data = LocalDateTime.now();
    if (listaItemNota.length > this.listaItemNota.length) {
      this.listaItemNota = new ItemNota[listaItemNota.length * 2];
    }
    System.arraycopy(listaItemNota, 0, this.listaItemNota, 0, listaItemNota.length);
    this.tamanhoAtual = listaItemNota.length;
  }

  public BigDecimal calcularTotalDaConta() {
    BigDecimal totalConta = BigDecimal.ZERO;
    for (ItemNota itemNota : this.listaItemNota) {
      if (itemNota != null) {
        totalConta = totalConta.add(itemNota.calcularSubtotal());
      }
    }
    return totalConta;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public ItemNota[] getListaItemNota() {
    return listaItemNota;
  }

  public void setListaItemNota(ItemNota[] listaItemNota) {
    this.listaItemNota = listaItemNota;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    sb.append("\n================== CUPOM FISCAL ==================\n");
    sb.append(String.format("       NOTA Nº: %05d%n", getId()));
    sb.append(String.format("       Data: %s%n", getData().format(formatter)));
    sb.append(String.format("       Cliente: %s%n", getCliente().getNome()));
    sb.append("--------------------------------------------------\n");
    sb.append("                      ITENS\n");
    sb.append("--------------------------------------------------\n");

    for (ItemNota item : this.listaItemNota) {
      if (item != null) {
        sb.append(item.toString()).append("\n");
      }
    }
    sb.append("--------------------------------------------------\n");
    sb.append(String.format("       VALOR TOTAL A PAGAR: R$ %.2f%n", calcularTotalDaConta()));
    sb.append("==================================================\n");

    return sb.toString();
  }
}
