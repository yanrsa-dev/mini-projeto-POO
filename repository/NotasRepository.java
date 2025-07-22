package repository;
import java.util.Optional;

import model.notas.Nota;


public class NotasRepository {
  private Nota[] notas= new Nota[tamanhoAtual];
  private int tamanhoAtual=0;
  private static Long contador=1L;
  
  public void adicionaNota(Nota nota){
  if(tamanhoAtual == notas.length){
        Nota[] novoArray = new Nota[notas.length + 10];
        System.arraycopy(notas,0,novoArray,0,notas.length);
       notas = novoArray;
    }
    nota.setId(contador++);
    notas[tamanhoAtual++] = nota;
  }

  public Nota[] listarNotas(){
   Nota[] notasAtuais = new Nota[tamanhoAtual];
     System.arraycopy(notas,0,notasAtuais,0,notas.length);
    return notasAtuais;
  }

  public Optional<Nota> getNotaById(Long id){
     for (int i = 0; i < tamanhoAtual; i++) {
        if (notas[i].getId().equals(id)) {
            return Optional.of(notas[i]);
        }
    }
    return Optional.empty();
}
