package repository;

import java.util.Optional;
import model.product.Produto;

public interface ProdutoRepository {

  void adicionaProduto(Produto produto);
  Produto[] listar();
  Optional<Produto> getProdutoById(Long id);
}

