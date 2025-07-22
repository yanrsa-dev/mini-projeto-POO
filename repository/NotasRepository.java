package repository;
import java.util.Optional;

import model.notas.Nota;


public interface NotasRepository {


  void adicionaNota(Nota nota);
 

  Nota[] listarNotas();
  

  Optional<Nota> getNotaById(Long id);
  
}
