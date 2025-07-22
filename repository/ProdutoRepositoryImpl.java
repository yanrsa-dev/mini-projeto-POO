package repository;

import java.util.Arrays;
import java.util.Optional;
import repository.ProdutoRepository;
import model.product.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {

  private int tamanhoAtual = 0;
  private Produto[] produtos = new Produto[10];
  private static Long contador = 1L;

  @Override
  public void adicionaProduto(Produto produto) {
    if (tamanhoAtual == produtos.length) {
      Produto[] novoArrayProdutos = new Produto[tamanhoAtual + 10];
      System.arraycopy(produtos, 0, novoArrayProdutos, 0, produtos.length);
      produtos = novoArrayProdutos;
    }
    produto.setId(contador++);
    produtos[tamanhoAtual]=produto;
    tamanhoAtual++;
  }

  @Override
  public Produto[] listar() {
    return Arrays.copyOf(produtos, tamanhoAtual);
  }

  @Override
  public Optional<Produto> getProdutoById(Long id) {
    for (int i = 0; i < tamanhoAtual; i++) {
      if (produtos[i] != null && produtos[i].getId().equals(id)) {
        return Optional.of(produtos[i]);
      }
    }
    return Optional.empty();
  }
}
