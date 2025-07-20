import java.util.List;
import model.product.Produto;
import model.product.ProdutoFisico;
import repository.ProdutoRepository;
import service.ProdutoService;

public class ProdutoController {

  private ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  public void criarProdutoFisicoNaoPericivel(Produto novoProduto) {
    if (novoProduto instanceof ProdutoFisico produtoFisico) {
      produtoService.criarProdutoFisicoNaoPericivel(
          produtoFisico.getNome(),
          produtoFisico.getPreco(),
          produtoFisico.getQuantidadeEmEstoque(),
          produtoFisico.getPeso(),
          produtoFisico.getTiposProdutos());
    } else {
      System.out.println("Produto informado não é físico.");
    }
  }

  public void criarProdutoFisicoPericivel(Produto novoProduto) {
    if (novoProduto instanceof ProdutoFisico produtoFisico) {
      produtoService.criarProdutoFisicoPericivel(
          produtoFisico.getNome(),
          produtoFisico.getPreco(),
          produtoFisico.getQuantidadeEmEstoque(),
          produtoFisico.getPeso(),
          produtoFisico.getTiposProdutos(),
          produtoFisico.getValidade());
    } else {
      System.out.println("Produto informado não é físico.");
    }
  }

  public void listarProdutos() {
    List<Produto> produtos = produtoService.listarProdutos();
    for (Produto p : produtos) {
      System.out.println(p);
    }
  }

  public Produto atualizarProdutoFisico(ProdutoFisico updateProduto, Long id) {
    return produtoService.atualizarProduto(updateProduto, id);
  }
}
