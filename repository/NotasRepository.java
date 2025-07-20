package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.notas.Nota;


public class NotasRepository {

  private List<Nota> notas = new ArrayList<>();

  public void adicionaNota(Nota nota){
    notas.add(nota);
  }

  public List<Nota> getNotas(){
    return notas;
  }

  public Optional<Nota> getNotaById(Long id){
    return notas.stream()
      .filter(n -> n.getId().equals(id))
      .findFirst();
  }
}
