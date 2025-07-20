package controller;
import enums.TiposProdutos;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import model.product.Produto;
import model.product.ProdutoDigital;
import model.product.ProdutoFisico;
import service.ProdutoService;

public class ProdutoController {

  private ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  public void criarProdutoFisicoPericivel(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      TiposProdutos tipo,
      LocalDate validade) {

    produtoService.criarProdutoFisicoPericivel(nome, preco, qtdEstoque, peso, tipo, validade);
  }

  public void criarProdutoFisicoNaoPericivel(
      String nome, BigDecimal preco, int qtdEstoque, double peso, TiposProdutos tipo) {
    produtoService.criarProdutoFisicoNaoPericivel(nome, preco, qtdEstoque, peso, tipo);
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

  public Produto atualizarProdutoDigital(ProdutoDigital updateProduto, Long id) {
    updateProduto.setId(id);
    return produtoService.atualizarProdutoDgital(updateProduto, id);
  }
}
