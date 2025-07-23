package controller;

import java.util.Arrays;
import java.util.List;

import model.cliente.Cliente;
import model.notas.ItemNota;
import model.notas.Nota;
import service.NotasService;

public class NotasController {

  private NotasService notasService;

  public NotasController(NotasService notasService) {
    this.notasService = notasService;
  }

  public Nota criar(Cliente cliente, ItemNota[] itens) {
    return notasService.criarNota(cliente, itens);
  }

  public void listar() {
   Nota[] notas = notasService.listarNotas();
    if (notas.length == 0) {
      System.out.println("Nao ha nenhuma nota");
    }
    for (Nota n : notas) {
      System.out.println(n);
    }
  }
}
