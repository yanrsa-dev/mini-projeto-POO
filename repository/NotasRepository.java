package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.notas.Nota;


public class NotasRepository {

  private List<Nota> notas = new ArrayList<>();
  private static Long contador=1L;

  public void adicionaNota(Nota nota){
    nota.setId(contador++);
    notas.add(nota);
  }

  public List<Nota> listarNotas(){
    return notas;
  }

  public Optional<Nota> getNotaById(Long id){
    return notas.stream()
      .filter(n -> n.getId().equals(id))
      .findFirst();
  }
}
