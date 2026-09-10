# Laboratório de Programação Modular - Prática 2

Repositório contendo a solução da **Prática 2 (Arrays e Collections)** da disciplina de Laboratório de Programação Modular da PUC Minas.

## 🛒 Sobre o Projeto

Este projeto consiste na implementação de um **Carrinho de Compras** para uma loja de suprimentos, focado na aplicação de conceitos de Orientação a Objetos e no uso de Coleções em Java (especificamente `ArrayList`).

### 📦 Estrutura do Sistema

O sistema foi modelado com as seguintes classes:
- **`Produto`**: Armazena as informações base dos suprimentos disponíveis (Nome, Código e Preço).
- **`Item`**: Representa um item da fatura, associando um Produto a uma Quantidade e calculando seu valor subtotal.
- **`Fatura`**: Gerencia o carrinho de compras utilizando um `ArrayList` de Itens, sendo responsável por calcular o valor total da compra.

### ⚙️ Funcionalidades (Menu Interativo)
O sistema apresenta um menu via console com as seguintes operações:
1. **Comprar:** Lista os produtos pré-cadastrados para o usuário selecionar por código e definir a quantidade.
2. **Ver Fatura:** Exibe todos os itens já adicionados ao carrinho e o valor total atualizado.
3. **Excluir Item:** Permite remover um item específico da fatura.
4. **Alterar Item:** Permite atualizar a quantidade de um produto que já está no carrinho.
5. **Finalizar:** Encerra a execução do programa e exibe o cupom/valor final da compra.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java
- **Coleções:** `java.util.ArrayList`
- **Gerenciamento:** Apache Maven
- **Ambiente:** Visual Studio Code

## 🚀 Como Executar

1. Clone este repositório.
2. Abra o projeto no VS Code.
3. Compile e execute a classe principal.
4. Siga as instruções do menu interativo no terminal. Lembre-se que em todos os menus há a opção de retornar sem realizar ações.

---
**Autor:** Diego Vitor Pinto Mariano Portella
