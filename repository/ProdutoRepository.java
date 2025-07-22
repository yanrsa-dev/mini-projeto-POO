package repository;
import java.util.Optional;

import model.product.Produto;

public class ProdutoRepository { 
  private Produto[] produtos= new Produto[tamanhoAtual];
  private int tamanhoAtual=0;
  private static Long contador=1L;
  
  public void adicionaProduto(Produto produto){
    if(tamanhoAtual == produtos.length){
        Produto[] novoArray = new Produto[produtos.length + 10];
        System.arraycopy(produtos,0,novoArray,0,produtos.length);
        produtos = novoArray;
    }
    produto.setId(contador++);
    produtos[tamanhoAtual++] = produto;
  }

  public Produto[] listar(){
     Produto[] produtosAtuais = new Produto[tamanhoAtual];
     System.arraycopy(produtos,0,produtosAtuais,0,produtos.length);
    return produtosAtuais;
  }

  public Optional<Produto> getProdutoById(Long id){
for (int i = 0; i < tamanhoAtual; i++) {
        if (produtos[i].getId().equals(id)) {
            return Optional.of(produtos[i]);
        }
    }
    return Optional.empty();

}

