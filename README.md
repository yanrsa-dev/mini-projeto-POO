# mini-projeto-POO
🛒 Mini-Projeto POO — Sistema de Vendas em Java
📌 Descrição
Este projeto é um sistema de ponto de vendas (PDV) simples, desenvolvido em Java como solução para uma pequena loja que precisava informatizar seu processo de vendas.

O sistema permite:

Cadastrar produtos (de diferentes categorias)

Registrar clientes (pessoa física e jurídica)

Emitir notas fiscais detalhadas
Tudo isso substituindo o processo manual de anotações e cálculos.

🎯 O foco principal foi aplicar corretamente os pilares e conceitos da Programação Orientada a Objetos (POO), visando um código limpo, organizado e fácil de manter.

🚀 Tecnologias Utilizadas
Java 17+

Paradigma: Programação Orientada a Objetos (POO)

Arquitetura em Camadas (MVC adaptado para console)

🧱 Arquitetura
O projeto segue o padrão de Arquitetura em Camadas, implementando o conceito MVC de forma adaptada para aplicações de console:

Model: Representa as entidades do sistema (Produto, Cliente, Nota, etc.)

Repository: Camada de acesso a dados (armazenamento em arrays)

Service: Contém a lógica de negócio e regras do sistema

Controller: Faz a ponte entre a View e os serviços

View: Interface com o usuário via console (ConsoleMenu, ProdutoUi, etc.)

🧠 Aplicação de Conceitos de POO
✅ Interfaces
Usadas para definir contratos nas classes de repositório, promovendo baixo acoplamento e respeitando o Princípio da Inversão de Dependência.

📍 Exemplo: ProdutoRepository, NotasRepository, ClienteRepository.

java
Copiar
Editar
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
}
🔼 Upcasting (Conversão Implícita)
Ocorre quando um objeto de uma subclasse é tratado como uma instância da superclasse (ProdutoAlimenticio → Produto).

📍 Exemplo:

java
Copiar
Editar
Produto novoProduto = new ProdutoAlimenticio(...);
produtoRepository.adicionaProduto(novoProduto); // Espera um Produto
🔍 instanceof (Verificação de Tipo)
Verifica o tipo real do objeto antes de fazer downcasting, garantindo segurança.

📍 Exemplo:

java
Copiar
Editar
if (produtoExistente instanceof ProdutoAlimenticio 
    && produtoAtualizado instanceof ProdutoAlimenticio) {
    // Pode fazer o downcast com segurança
}
🔽 Downcasting (Conversão Explícita)
Converte explicitamente um objeto genérico (Produto) para sua forma mais específica, após confirmação com instanceof.

📍 Exemplos:

java
Copiar
Editar
// Dentro de um método de atualização
ProdutoAlimenticio existente = (ProdutoAlimenticio) produtoExistente;
ProdutoAlimenticio atualizado = (ProdutoAlimenticio) produtoAtualizado;
existente.setValidade(atualizado.getValidade());

// Em um método de criação
return (ProdutoAlimenticio) novoProduto;
