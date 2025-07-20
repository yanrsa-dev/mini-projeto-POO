package model.notas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;
import model.notas.ItemNota;

public class Nota {


  private Cliente cliente;
  private List<ItemNota> listaItemNota;
  private Long id;
  private LocalDateTime data;

  public Nota(){
    this.listaItemNota=new ArrayList<>();
  }

  public Nota(Cliente cliente, List<ItemNota> listaItemNota){
    this.cliente=cliente;
    this.listaItemNota= listaItemNota;
    this.data = LocalDateTime.now();
  }


  public BigDecimal calcularTotalDaConta(List<ItemNota> listaItemNota){
    BigDecimal totalConta = BigDecimal.ZERO;
    for(ItemNota itemNota : listaItemNota){
      totalConta = totalConta.add(itemNota.calcularSubtotal());
    }
    return totalConta;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ItemNota> getListaItemNota() {
    return listaItemNota;
  }

  public void setListaItemNota(List<ItemNota> listaItemNota) {
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
    return "Nota [cliente=" + cliente + ", listaItemNota=" + listaItemNota + "]" + "Total [total= R$" + calcularTotalDaConta(listaItemNota) + "]";
  }
  

  
}
