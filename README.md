# 🛒 Sistema de Vendas em Java - Mini-Projeto POO

## 📌 Descrição

Este projeto é um sistema de **ponto de vendas (PDV)** simples, desenvolvido em **Java** como solução para uma pequena loja que precisava informatizar seu processo de vendas.

O sistema permite:
- 📦 Cadastrar produtos (de diferentes categorias)
- 👥 Registrar clientes (pessoa física e jurídica)
- 🧾 Emitir notas fiscais detalhadas

Tudo isso substituindo o processo manual de anotações e cálculos.

🎯 **Objetivo Principal:** Aplicar corretamente os **pilares e conceitos da Programação Orientada a Objetos (POO)**, visando um código limpo, organizado e fácil de manter.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 17+**
- 🏗️ **Paradigma:** Programação Orientada a Objetos (POO)
- 📐 **Arquitetura:** Camadas (MVC adaptado para console)

---

## 🧱 Arquitetura do Sistema

O projeto segue o padrão de **Arquitetura em Camadas**, implementando o conceito MVC de forma adaptada para aplicações de console:

| Camada | Responsabilidade | Exemplos |
|--------|------------------|----------|
| **Model** | Representa as entidades do sistema | `Produto`, `Cliente`, `Nota` |
| **Repository** | Camada de acesso a dados | Armazenamento em arrays |
| **Service** | Contém a lógica de negócio e regras | Validações e processamentos |
| **Controller** | Ponte entre View e serviços | Coordenação de fluxos |
| **View** | Interface com o usuário via console | `ConsoleMenu`, `ProdutoUi` |

---

## 🧠 Conceitos de POO Aplicados

### ✅ **Interfaces**
Interfaces foram utilizadas para definir contratos nas classes de repositório, promovendo **baixo acoplamento** e respeitando o **Princípio da Inversão de Dependência**.

**Exemplo:**
```java
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
}
```

### 🔼 **Upcasting (Conversão Implícita)**
Ocorre quando um objeto de uma subclasse é tratado como uma instância da superclasse (`ProdutoAlimenticio` → `Produto`). Isso permite que métodos que trabalham com a superclasse aceitem qualquer subtipo dela.

**Exemplo:**
```java
public ProdutoAlimenticio criarProdutoAlimenticio(...) {
    Produto novoProduto = new ProdutoAlimenticio(...);
    produtoRepository.adicionaProduto(novoProduto); // Espera um Produto
    return (ProdutoAlimenticio) novoProduto;
}
```

### 🔍 **instanceof (Verificação de Tipo)**
O operador `instanceof` verifica o tipo real do objeto em tempo de execução antes de realizar um downcasting, garantindo que ele seja seguro.

**Exemplo:**
```java
public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
    Produto produtoExistente = produtoRepository.getProdutoById(id).orElse(null);
    
    if (produtoExistente instanceof ProdutoAlimenticio 
        && produtoAtualizado instanceof ProdutoAlimenticio) {
        // Pode fazer o downcast com segurança
    }
    return produtoExistente;
}
```

### 🔽 **Downcasting (Conversão Explícita)**
Converte um objeto da superclasse de volta para seu tipo mais específico. Deve ser feito somente após confirmação com `instanceof`.

**Exemplos:**
```java
// Dentro do método de atualização
ProdutoAlimenticio existente = (ProdutoAlimenticio) produtoExistente;
ProdutoAlimenticio atualizado = (ProdutoAlimenticio) produtoAtualizado;
existente.setValidade(atualizado.getValidade());
```

```java
// Em um método de criação
public ProdutoAlimenticio criarProdutoAlimenticio(...) {
    Produto novoProduto = new ProdutoAlimenticio(...);
    produtoRepository.adicionaProduto(novoProduto);
    return (ProdutoAlimenticio) novoProduto; // Downcasting seguro
}
```

---

## 🎯 Funcionalidades

- ➕ **Cadastro de Produtos:** Diferentes categorias com suas especificidades
- 👤 **Gestão de Clientes:** Suporte para pessoa física e jurídica
- 🧾 **Emissão de Notas:** Cálculos automáticos e detalhamento completo
- 💾 **Persistência:** Sistema de armazenamento em memória
- 🎨 **Interface Console:** Menu interativo e intuitivo

---

## 🏃‍♂️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/sistema-vendas-java.git
   ```

2. **Navegue até o diretório:**
   ```bash
   cd sistema-vendas-java
   ```

3. **Compile o projeto:**
   ```bash
   javac -d bin src/**/*.java
   ```

4. **Execute a aplicação:**
   ```bash
   java -cp bin Main
   ```

---

## 📁 Estrutura do Projeto

```
src/
├── model/          # Entidades do sistema
├── repository/     # Camada de dados
├── service/        # Lógica de negócio
├── controller/     # Controladores
├── view/           # Interface do usuário
└── Main.java       # Ponto de entrada
```

---

## 🎓 Conceitos Demonstrados

- **Encapsulamento:** Atributos privados com getters/setters
- **Herança:** Hierarquia de classes de produtos e clientes
- **Polimorfismo:** Métodos sobrescritos e interfaces
- **Abstração:** Classes abstratas e interfaces
- **Composição:** Relacionamentos entre objetos
- **Princípios SOLID:** Especialmente SRP e DIP

---
