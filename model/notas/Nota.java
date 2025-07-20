package model.notas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;
import model.notas.ItemNota;

public class Nota {

  private static Long contador=1L;

  private Cliente cliente;
  private List<ItemNota> listaItemNota;
  private Long id;

  public Nota(){
    this.listaItemNota=new ArrayList<>();
    this.id=contador++;
  }

  public Nota(Cliente cliente, List<ItemNota> listaItemNota){
    this.cliente=cliente;
    this.listaItemNota= new ArrayList<>();
    this.id=contador++;
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

  public Long getId(){
    return id;
  }
  
}
