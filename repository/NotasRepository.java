package repository;
import java.util.ArrayList;
import java.util.List;
import model.notas.Nota;


public class NotasRepository {

  private List<Nota> notas = new ArrayList<>();

  public void adicionaNota(Nota nota){
    notas.add(nota);
  }

  public List<Nota> getNotas(){
    return notas;
  }
}
