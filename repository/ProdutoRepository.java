package repository;
import java.util.ArrayList;
import java.util.List;

import model.product.Produto;

public class ProdutoRepository {
  private List<Produto> produtos = new ArrayList<>();
  
  public void adicionaProduto(Produto produto){
    produtos.add(produto);
  }

  public List<Produto> getProdutos(){
    return produtos;
  }

}
