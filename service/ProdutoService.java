package service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import model.product.Produto;
import model.product.ProdutoAlimenticio;
import model.product.ProdutoEletronico;
import model.product.ProdutoDomesticos;
import repository.ProdutoRepositoryImpl;

public class ProdutoService {

  private ProdutoRepositoryImpl produtoRepository;

  public ProdutoService(ProdutoRepositoryImpl produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public ProdutoAlimenticio criarProdutoAlimenticio(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      LocalDate validade) {
    Produto novoProduto =
        new ProdutoAlimenticio(nome, preco, qtdEstoque, peso, marca, validade);
    produtoRepository.adicionaProduto(novoProduto);
    return (ProdutoAlimenticio) novoProduto;
  }

  public ProdutoEletronico criarProdutoEletronico(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      int voltagem,
      LocalDate garantia) {
    Produto novoProduto =
        new ProdutoEletronico(nome, preco, qtdEstoque, peso, marca, voltagem, garantia);
    produtoRepository.adicionaProduto(novoProduto);
    return (ProdutoEletronico) novoProduto;
  }

  public ProdutoDomesticos criarProdutosDomesticos(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      String material,
      String utilidade) {
    Produto novoProduto =
        new ProdutoDomesticos(nome, preco, qtdEstoque, peso, marca, material, utilidade);
    produtoRepository.adicionaProduto(novoProduto);
    return (ProdutoDomesticos) novoProduto;
  }

  public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
    Produto produtoExistente =
        produtoRepository
            .getProdutoById(id)
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Produto de id " + id + " não encontrado para atualização."));

    produtoExistente.setNome(produtoAtualizado.getNome());
    produtoExistente.setPreco(produtoAtualizado.getPreco());
    produtoExistente.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
    produtoExistente.setMarca(produtoAtualizado.getMarca());
    produtoExistente.setPeso(produtoAtualizado.getPeso());

    if (produtoExistente instanceof ProdutoAlimenticio
        && produtoAtualizado instanceof ProdutoAlimenticio) {
      ProdutoAlimenticio existente = (ProdutoAlimenticio) produtoExistente;
      ProdutoAlimenticio atualizado = (ProdutoAlimenticio) produtoAtualizado;
      existente.setValidade(atualizado.getValidade());

    } else if (produtoExistente instanceof ProdutoEletronico
        && produtoAtualizado instanceof ProdutoEletronico) {
      ProdutoEletronico existente = (ProdutoEletronico) produtoExistente;
      ProdutoEletronico atualizado = (ProdutoEletronico) produtoAtualizado;
      existente.setVoltagem(atualizado.getVoltagem());
      existente.setGarantia(atualizado.getGarantia());

    } else if (produtoExistente instanceof ProdutoDomesticos
        && produtoAtualizado instanceof ProdutoDomesticos) {
      ProdutoDomesticos existente = (ProdutoDomesticos) produtoExistente;
      ProdutoDomesticos atualizado = (ProdutoDomesticos) produtoAtualizado;
      existente.setMaterial(atualizado.getMaterial());
      existente.setUtilidade(atualizado.getUtilidade());
    }

    return produtoExistente;
  }

  public Optional<Produto> listarProdutoById(Long id){
    return produtoRepository.getProdutoById(id);
  }

  public Produto[] listarProdutos() {
    return produtoRepository.listar();
  }
}
