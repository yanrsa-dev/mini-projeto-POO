package repository;


import java.util.Arrays;
import java.util.Optional;
import repository.NotasRepository;
import model.notas.Nota;

public class NotasRepositoryImpl implements NotasRepository {

  private int tamanhoAtual = 0;
  private Nota[] notas = new Nota[10];
  private static Long contador = 1L;

  @Override
  public void adicionaNota(Nota nota) {
    if (tamanhoAtual == notas.length) {
      Nota[] novoArrayNotas = new Nota[notas.length + 10];
      System.arraycopy(notas, 0, novoArrayNotas, 0, notas.length);
      notas = novoArrayNotas;
    }
    nota.setId(contador++);
    notas[tamanhoAtual++] = nota;
  }

  @Override
  public Nota[] listarNotas() {
    return Arrays.copyOf(notas, tamanhoAtual);
  }

  @Override
  public Optional<Nota> getNotaById(Long id) {
    for (int i = 0; i < tamanhoAtual; i++) {
      if (notas[i] != null && notas[i].getId().equals(id)) {
        return Optional.of(notas[i]);
      }
    }
    return Optional.empty();
  }
}
