import controller.ClienteController;
import controller.NotasController;
import controller.ProdutoController;
import repository.ClienteRepository;
import repository.NotasRepositoryImpl;
import repository.ProdutoRepositoryImpl;
import service.ClienteService;
import service.NotasService;
import service.ProdutoService;
import ui.ConsoleMenu;
import ui.modelsUi.ClienteUi;
import ui.modelsUi.NotaUi;
import ui.modelsUi.ProdutoUi;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ProdutoRepositoryImpl produtoRepository = new ProdutoRepositoryImpl();
        NotasRepositoryImpl notasRepository = new NotasRepositoryImpl();

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
