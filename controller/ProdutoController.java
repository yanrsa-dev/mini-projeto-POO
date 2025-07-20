import repository.ProdutoRepository;
import service.ProdutoService;

public class ProdutoController {

  private ProdutoService produtoService;
  private ProdutoRepository produtoRepository;

  public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository){
    this.produtoService=produtoService;
    this.produtoRepository=produtoRepository;
  }

  public void criarProdutoFisicoNaoPericivel(Produto novoProduto){
    produtoService.criarProdutoFisicoNaoPericivel(novoProduto.getNome()
        , novoProduto.getPreco(),novoProduto.getPreco(), novoProduto.getQuantidadeEmEstoque(), novoProduto.get)
  }

}
