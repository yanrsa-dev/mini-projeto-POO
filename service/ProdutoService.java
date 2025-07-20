package service;

import enums.TiposProdutos;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import model.product.Produto;
import model.product.ProdutoDigital;
import model.product.ProdutoFisico;
import repository.ProdutoRepository;

public class ProdutoService {

  private ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public ProdutoFisico criarProdutoFisicoNaoPericivel(
      String nome,
      BigDecimal preco,
      int quantidadeEmEstoque,
      double peso,
      TiposProdutos tiposProdutos) {
    ProdutoFisico novoProdutoFisico =
        new ProdutoFisico(nome, preco, quantidadeEmEstoque, peso, tiposProdutos);
    produtoRepository.adicionaProduto(novoProdutoFisico);
    return novoProdutoFisico;
  }

  public ProdutoFisico criarProdutoFisicoPericivel(
      String nome,
      BigDecimal preco,
      int quantidadeEmEstoque,
      double peso,
      TiposProdutos tiposProdutos,
      LocalDate validade) {
    ProdutoFisico novoProdutoFisico =
        new ProdutoFisico(nome, preco, quantidadeEmEstoque, peso, tiposProdutos, validade);
    produtoRepository.adicionaProduto(novoProdutoFisico);
    return novoProdutoFisico;
  }

  public ProdutoDigital criarProdutoDigital(
      String nome, BigDecimal preco, int quantidadeEmEstoque, double distanciaEntreCompradorLoja) {
    ProdutoDigital novoProdutoDigital =
        new ProdutoDigital(nome, preco, quantidadeEmEstoque, distanciaEntreCompradorLoja);
    produtoRepository.adicionaProduto(novoProdutoDigital);
    return novoProdutoDigital;
  }

  public ProdutoFisico atualizarProduto(ProdutoFisico novoProduto, Long id) {
    Optional<Produto> opt = produtoRepository.getProdutoById(id);
    if (opt.isPresent() && opt.get() instanceof ProdutoFisico) {
      ProdutoFisico produtoExistente = (ProdutoFisico) opt.get();
      produtoExistente.setNome(novoProduto.getNome());
      produtoExistente.setPreco(novoProduto.getPreco());
      produtoExistente.setQuantidadeEmEstoque(novoProduto.getQuantidadeEmEstoque());
      produtoExistente.setPeso(novoProduto.getPeso());
      produtoExistente.setTiposProdutos(novoProduto.getTiposProdutos());
      if (novoProduto.getValidade() != null) {
        produtoExistente.setValidade(novoProduto.getValidade());
      }
      return produtoExistente;
    }
    throw new RuntimeException("Produto de id " + id + " nao encontrado");
  }

  public ProdutoDigital atualizarProdutoDgital(ProdutoDigital novoProduto, Long id) {
    Optional<Produto> opt = produtoRepository.getProdutoById(id);
    if (opt.isPresent() && opt.get() instanceof ProdutoDigital) {
      ProdutoDigital produtoExistente = (ProdutoDigital) opt.get();
      produtoExistente.setNome(novoProduto.getNome());
      produtoExistente.setPreco(novoProduto.getPreco());
      produtoExistente.setQuantidadeEmEstoque(novoProduto.getQuantidadeEmEstoque());
      produtoExistente.setDistanciaEntreCompradorLoja(novoProduto.getDistanciaEntreCompradorLoja());
      return produtoExistente;
    }

    throw new RuntimeException("Produto de id " + id + " nao encontrado");
  }

  public List<Produto> listarProdutos() {
    return produtoRepository.getProdutos();
  }
}
