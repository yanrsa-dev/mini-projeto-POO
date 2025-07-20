package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import service.ProdutoService;
import model.product.Produto;

public class ProdutoController {

  private ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  public void criarProdutoAlimenticio(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      LocalDate validade) {
    produtoService.criarProdutoAlimenticio(nome, preco, qtdEstoque, peso, marca, validade);
  }

  public void criarProdutoEletronico(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      int voltagem,
      LocalDate garantia) {
    produtoService.criarProdutoEletronico(nome, preco, qtdEstoque, peso, marca, voltagem, garantia);
  }

  public void criarProdutosDomesticos(
      String nome,
      BigDecimal preco,
      int qtdEstoque,
      double peso,
      String marca,
      String material,
      String utilidade) {
    produtoService.criarProdutosDomesticos(
        nome, preco, qtdEstoque, peso, marca, material, utilidade);
  }

  public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
    return produtoService.atualizarProduto(id, produtoAtualizado);
  }

  public Optional<Produto> buscarProdutoById(Long id){
    return produtoService.listarProdutoById(id);
  }

  public void listarProdutos() {
    List<Produto> produtos = produtoService.listarProdutos();
    if (produtos.isEmpty()) {
      System.out.println("Nenhum produto cadastrado no sistema.");
      return;
    }
    System.out.println("\n--- LISTA DE PRODUTOS ---");
    for (Produto p : produtos) {
      // O método toString() de cada subclasse será chamado automaticamente
      System.out.println(p);
    }
  }
}
