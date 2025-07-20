package service;
import java.util.List;
import model.notas.Nota;
import repository.NotasRepository;
import model.notas.ItemNota;
import model.cliente.Cliente;

public class NotasService {

  private NotasRepository notasRepository;
  public NotasService(NotasRepository notasRepository) {
    this.notasRepository = notasRepository;
  }

  public Nota criarNota(Cliente cliente, List<ItemNota> itens) {
    Nota novaNota = new Nota(cliente, itens);
    notasRepository.adicionaNota(novaNota);
    return novaNota;
  }

  public List<Nota> listarNotas() {
    return notasRepository.getNotas();
  }
}
