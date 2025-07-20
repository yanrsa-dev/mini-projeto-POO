import java.util.List;
import model.notas.Nota;
import repository.NotasRepository;
import service.NotasService;

public class NotasController {

  private NotasService notasService;
  private NotasRepository notasRepository;

  public NotasController(NotasService notasService, NotasRepository notasRepository) {
    this.notasService = notasService;
    this.notasRepository = notasRepository;
  }

  public Nota criar(Nota nota) {
    return notasService.criarNota(nota.getCliente(), nota.getListaItemNota());
  }

  public void listar() {
    List<Nota> notas = notasRepository.listarNotas();
    if (notas.isEmpty()) {
      System.out.println("Nao ha nenhuma nota");
    }
    for (Nota n : notas) {
      System.out.println(n);
    }
  }
}
