package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.product.Produto;

public class ProdutoRepository {
  private List<Produto> produtos = new ArrayList<>();
  private static Long contador=1L;
  
  public void adicionaProduto(Produto produto){
    produto.setId(contador++);
    produtos.add(produto);
  }

  public List<Produto> listar(){
    return produtos;
  }

  public Optional<Produto> getProdutoById(Long id){
    return produtos.stream()
      .filter(p -> p.getId().equals(id))
      .findFirst();
  }

}
