# mini-projeto-POO
Projeto Lojinha - Sistema de Vendas em Java
Descrição
Este projeto é um sistema de ponto de vendas (PDV) simples, desenvolvido em Java como solução para uma pequena loja que necessitava informatizar seu processo de vendas. O sistema permite cadastrar produtos (com diferentes categorias), registrar clientes (pessoas físicas e jurídicas) e emitir notas de compra detalhadas, substituindo o processo manual de anotações e cálculos.

O foco principal do projeto foi a aplicação correta dos pilares e conceitos da Programação Orientada a Objetos (POO) para criar um código bem estruturado, manutenível e extensível.

Tecnologias Utilizadas
Java 17 (ou superior)

Programação Orientada a Objetos (POO)

Arquitetura
O sistema foi desenvolvido seguindo o padrão de Arquitetura em Camadas (Layered Architecture), que implementa os conceitos do MVC (Model-View-Controller) de forma adaptada para uma aplicação de console. As responsabilidades são divididas da seguinte forma:

Model (Camada de Domínio): Representa as entidades do negócio (Produto, Cliente, Nota, etc.).

Repository (Camada de Acesso a Dados): Abstrai a fonte de dados (atualmente, um array em memória).

Service (Camada de Lógica de Negócio): Contém as regras de negócio e orquestra as operações.

Controller (Camada de Controle): Atua como intermediário entre a View e a Service.

View (Camada de Apresentação): Interface do usuário via console (ConsoleMenu, ProdutoUi, etc.).

Aplicação dos Conceitos de POO
Esta seção detalha onde os principais conceitos de Programação Orientada a Objetos foram aplicados no projeto.

Interfaces
As interfaces foram utilizadas para definir "contratos" para a camada de acesso a dados (Repository), promovendo o baixo acoplamento e aplicando o Princípio da Inversão de Dependência.

Onde? Na definição de ProdutoRepository, NotasRepository e ClienteRepository.

Explicação: A camada de Service depende da interface do repositório, e não da sua implementação concreta (...Impl). Isso significa que o serviço não precisa saber como os dados são salvos (se é em um array, em um arquivo ou em um banco de dados), apenas que o contrato (os métodos adicionar, listar, etc.) será cumprido.

Exemplo (ProdutoService.java):

Java

public class ProdutoService {
    // O serviço depende da abstração (interface), não do detalhe (classe).
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
}
Upcasting (Conversão Implícita)
O Upcasting é utilizado quando um objeto de um tipo mais específico é tratado como um tipo mais geral. Isso acontece de forma implícita e é fundamental para o polimorfismo.

Onde? Nos métodos de criação da ProdutoService.

Explicação: Ao criar um new ProdutoAlimenticio(...), que é um tipo específico, nós o atribuímos a uma variável do tipo Produto, que é a superclasse. O mesmo ocorre ao passar esse objeto para o método produtoRepository.adicionaProduto(novoProduto), que espera um Produto genérico.

Exemplo (ProdutoService.java):

Java

public ProdutoAlimenticio criarProdutoAlimenticio(...) {
    // Um objeto ProdutoAlimenticio é criado...
    // ...e tratado como um Produto genérico (Upcast).
    Produto novoProduto = new ProdutoAlimenticio(...);

    // O repositório recebe um Produto, sem precisar saber o tipo específico.
    produtoRepository.adicionaProduto(novoProduto); 

    // ...
}
instanceof (Verificação de Tipo)
O operador instanceof é usado para verificar o tipo real de um objeto em tempo de execução. Isso é crucial para tratar objetos polimórficos de forma segura antes de realizar um Downcast.

Onde? No método atualizarProduto da ProdutoService.

Explicação: O método recebe um Produto genérico. Para acessar atributos específicos (como validade ou voltagem), primeiro precisamos confirmar se o objeto é do tipo esperado (ex: ProdutoAlimenticio). O instanceof faz essa verificação de segurança.

Exemplo (ProdutoService.java):

Java

public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
    Produto produtoExistente = ...;

    // Verifica se o objeto existente E o objeto com novos dados são do tipo ProdutoAlimenticio.
    if (produtoExistente instanceof ProdutoAlimenticio 
        && produtoAtualizado instanceof ProdutoAlimenticio) {

        // Só entra aqui se a verificação for verdadeira.
        // ...
    }
}
Downcasting (Conversão Explícita)
O Downcasting é o processo de converter um tipo mais geral de volta para seu tipo mais específico. É uma operação explícita e que requer cuidado, geralmente sendo precedida por uma verificação com instanceof.

Onde? Também no método atualizarProduto e no return dos métodos de criação em ProdutoService.

Explicação: Após o instanceof confirmar que produtoExistente é de fato um ProdutoAlimenticio, fazemos o "cast" explícito (ProdutoAlimenticio) produtoExistente. Isso nos dá acesso aos métodos específicos da subclasse, como setValidade(). O mesmo ocorre nos métodos criar..., onde a variável novoProduto (do tipo Produto) é convertida de volta para seu tipo original no return.

Exemplos (ProdutoService.java):

Java

// Exemplo 1: Dentro do método de atualização
if (produtoExistente instanceof ProdutoAlimenticio ...) {
    // Downcast seguro para acessar métodos específicos.
    ProdutoAlimenticio existente = (ProdutoAlimenticio) produtoExistente; 
    ProdutoAlimenticio atualizado = (ProdutoAlimenticio) produtoAtualizado;
    existente.setValidade(atualizado.getValidade());
}

// Exemplo 2: No retorno de um método de criação
public ProdutoAlimenticio criarProdutoAlimenticio(...) {
    Produto novoProduto = new ProdutoAlimenticio(...);
    produtoRepository.adicionaProduto(novoProduto);
    // Downcast seguro, pois sabemos que 'novoProduto' é um ProdutoAlimenticio.
    return (ProdutoAlimenticio) novoProduto; 
}
Como Executar
Clone o repositório.

Navegue até a pasta raiz do projeto pelo terminal.

Compile todos os arquivos .java:

Bash

javac */*.java */*/*.java
(Ajuste os caminhos conforme a estrutura de pastas do seu projeto, por exemplo: javac ui/*.java controller/*.java ...)

Execute a classe principal que contém o método main:

Bash

java Main 
(ou java App, dependendo do nome que você deu à classe principal).

