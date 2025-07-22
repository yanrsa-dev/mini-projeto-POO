package service;


import java.util.Optional;
import model.cliente.Cliente;
import model.notas.ItemNota;
import model.notas.Nota;
import model.product.Produto;
import repository.NotasRepository;

public class NotasService {

  private NotasRepository notasRepository;

  public NotasService(NotasRepository notasRepository) {
    this.notasRepository = notasRepository;
  }

  public Nota criarNota(Cliente cliente, List<ItemNota> itens) {
    for (ItemNota item : itens) {
      Produto produtoNoEstoque = item.getProduto();
      int quantidadeComprada = item.getQuantidadeDeItens();

      if (produtoNoEstoque.getQuantidadeEmEstoque() < quantidadeComprada) {
        throw new RuntimeException(
            "Estoque insuficiente para o produto: " + produtoNoEstoque.getNome());
      }

      int novoEstoque = produtoNoEstoque.getQuantidadeEmEstoque() - quantidadeComprada;

      produtoNoEstoque.setQuantidadeEmEstoque(novoEstoque);
    }
    Nota novaNota = new Nota(cliente, itens);
    notasRepository.adicionaNota(novaNota);
    return novaNota;
  }

  public Nota[] listarNotas() {
    return notasRepository.listarNotas();
  }

  public Nota filtrarNota(Long id) {
    Optional<Nota> opt = notasRepository.getNotaById(id);
    if (opt.isPresent()) {
      return (Nota) opt.get();
    }
    throw new RuntimeException("Nota de id: " + id + " nao encontrada");
  }
}
