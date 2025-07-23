import controller.ClienteController;
import controller.NotasController;
import controller.ProdutoController;
import repository.ClienteRepository;
import repository.NotasRepositoryImpl;
import repository.NotasRepository;
import repository.ProdutoRepository;
import repository.ProdutoRepositoryImpl;
import service.ClienteService;
import service.NotasService;
import service.ProdutoService;
import view.ConsoleMenu;
import view.modelsUi.ClienteUi;
import view.modelsUi.NotaUi;
import view.modelsUi.ProdutoUi;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ProdutoRepository produtoRepository = new ProdutoRepositoryImpl();
        NotasRepository notasRepository = new NotasRepositoryImpl();

        ClienteService clienteService = new ClienteService(clienteRepository);
        ProdutoService produtoService = new ProdutoService(produtoRepository);
        NotasService notasService = new NotasService(notasRepository);

        ClienteController clienteController = new ClienteController(clienteService);
        ProdutoController produtoController = new ProdutoController(produtoService);
        NotasController notasController = new NotasController(notasService);

        ProdutoUi produtoUi = new ProdutoUi(produtoController); 
        ClienteUi clienteUi = new ClienteUi(clienteController, clienteRepository, clienteService); 
        NotaUi notaUi = new NotaUi(notasController, produtoController, clienteController);

        ConsoleMenu menu = new ConsoleMenu(produtoUi, notaUi, clienteUi);

        menu.fluxoDeDados();
    }
}
