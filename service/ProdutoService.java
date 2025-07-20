package service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import model.product.ProdutoFisico;
import model.product.ProdutoDigital;
import repository.ProdutoRepository;
import enums.TiposProdutos;
import model.product.Produto;

public class ProdutoService {

  private ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository){
    this.produtoRepository=produtoRepository;
  }

  public ProdutoFisico criarProdutoFisicoNaoPericivel(String nome, BigDecimal preco, int quantidadeEmEstoque, double peso, TiposProdutos tiposProdutos){
    ProdutoFisico novoProdutoFisico = new ProdutoFisico(nome, preco, quantidadeEmEstoque, peso, tiposProdutos);
    produtoRepository.adicionaProduto(novoProdutoFisico);
    return novoProdutoFisico;
  }

  public ProdutoFisico criarProdutoFisicoPericivel(String nome, BigDecimal preco, int quantidadeEmEstoque, double peso, TiposProdutos tiposProdutos, LocalDate validade){
    ProdutoFisico novoProdutoFisico = new ProdutoFisico(nome, preco, quantidadeEmEstoque, peso, tiposProdutos, validade);
    produtoRepository.adicionaProduto(novoProdutoFisico);
    return novoProdutoFisico;
  }

  public ProdutoDigital criarProdutoDigital(String nome, BigDecimal preco, int quantidadeEmEstoque, double distanciaEntreCompradorLoja){
    ProdutoDigital novoProdutoDigital = new ProdutoDigital(nome, preco, quantidadeEmEstoque, distanciaEntreCompradorLoja);
    produtoRepository.adicionaProduto(novoProdutoDigital);
    return novoProdutoDigital;
  }


  public List<Produto> listarProdutos(){
    return produtoRepository.getProdutos();
  }
}
