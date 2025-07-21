package controller;
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

  public Nota criar(Cliente cliente, List<ItemNota> itens) {
    return notasService.criarNota(cliente, itens);
  }

  public void listar() {
    List<Nota> notas = notasService.listarNotas();
    if (notas.isEmpty()) {
      System.out.println("Nao ha nenhuma nota");
    }
    for (Nota n : notas) {
      System.out.println(n);
    }
  }
}
