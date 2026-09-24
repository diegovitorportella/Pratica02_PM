import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Fatura fatura = new Fatura();

        estoque.adicionarProduto(new Produto("Teclado Mecânico", "001", 350.00, 10));
        estoque.adicionarProduto(new Produto("Mouse sem fio", "002", 120.00, 3));
        estoque.adicionarProduto(new Produto("Monitor 24pol", "003", 850.00, 15));

        int opcao = -1;
        while (opcao != 10) {
            System.out.println("\n=== LOJA DE SUPRIMENTOS ===");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item da Fatura");
            System.out.println("4 - Alterar item da Fatura");
            System.out.println("5 - Consultar Produto (Estoque)");
            System.out.println("6 - Adicionar Produto ao Estoque");
            System.out.println("7 - Remover Produto (Estoque)");
            System.out.println("8 - Repor Estoque");
            System.out.println("9 - Produtos com Estoque Baixo");
            System.out.println("10 - Finalizar");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n-- COMPRAR --");
                    estoque.listarProdutos();
                    System.out.print("Informe o código do produto (ou '0' para voltar): ");
                    String codCompra = scanner.nextLine();
                    if (codCompra.equals("0")) break;

                    if (estoque.verificarExistencia(codCompra)) {
                        Produto p = estoque.buscarProduto(codCompra);
                        System.out.print("Quantidade desejada: ");
                        int qtd = scanner.nextInt();

                        if (p.retirarEstoque(qtd)) {
                            fatura.adicionarItem(new Item(p, qtd));
                            System.out.println("Item adicionado à fatura com sucesso!");
                        } else {
                            System.out.println("Erro: Estoque insuficiente.");
                        }
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;

                case 2:
                    System.out.println("\n-- FATURA ATUAL --");
                    if (fatura.getItens().isEmpty()) {
                        System.out.println("Fatura vazia.");
                    } else {
                        for (int i = 0; i < fatura.getItens().size(); i++) {
                            Item item = fatura.getItens().get(i);
                            System.out.printf("[%d] %s | Qtd: %d | Subtotal: R$%.2f\n", 
                                i, item.getProduto().getNome(), item.getQuantidade(), item.getValor_Total());
                        }
                        System.out.printf("Total da Fatura: R$%.2f\n", fatura.getTotal_Fatura());
                    }
                    break;

                case 3:
                    System.out.print("\nInforme o índice do item a excluir (ou -1 para voltar): ");
                    int indiceExc = scanner.nextInt();
                    if (indiceExc == -1) break;

                    Item itemExc = fatura.getItem(indiceExc);
                    if (itemExc != null) {
                        itemExc.getProduto().adicionarEstoque(itemExc.getQuantidade()); // Devolve ao estoque
                        fatura.removerItem(indiceExc);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.print("\nInforme o índice do item a alterar (ou -1 para voltar): ");
                    int indiceAlt = scanner.nextInt();
                    if (indiceAlt == -1) break;

                    Item itemAlt = fatura.getItem(indiceAlt);
                    if (itemAlt != null) {
                        System.out.print("Nova quantidade: ");
                        int novaQtd = scanner.nextInt();
                        
                        int diferenca = novaQtd - itemAlt.getQuantidade();
                        if (diferenca > 0) {
                            if (itemAlt.getProduto().retirarEstoque(diferenca)) {
                                itemAlt.setQuantidade(novaQtd);
                                fatura.atualizarValorTotalFatura();
                                System.out.println("Quantidade atualizada com sucesso.");
                            } else {
                                System.out.println("Estoque insuficiente para esse acréscimo.");
                            }
                        } else {
                            itemAlt.getProduto().adicionarEstoque(Math.abs(diferenca));
                            itemAlt.setQuantidade(novaQtd);
                            fatura.atualizarValorTotalFatura();
                            System.out.println("Quantidade reduzida com sucesso.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 5:
                    System.out.print("\nCódigo do produto para consulta (ou '0' para voltar): ");
                    String codBusca = scanner.nextLine();
                    if (codBusca.equals("0")) break;
                    
                    Produto pBusca = estoque.buscarProduto(codBusca);
                    if (pBusca != null) {
                        System.out.printf("Encontrado: %s | Preço: R$%.2f | Estoque: %d\n", 
                            pBusca.getNome(), pBusca.getPreco(), pBusca.getQuantidadeEstoque());
                    } else {
                        System.out.println("Produto inexistente.");
                    }
                    break;

                case 6:
                    System.out.println("\n-- NOVO PRODUTO --");
                    System.out.print("Nome ('0' para voltar): ");
                    String nome = scanner.nextLine();
                    if (nome.equals("0")) break;

                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade inicial: ");
                    int qtdInic = scanner.nextInt();

                    if (estoque.adicionarProduto(new Produto(nome, codigo, preco, qtdInic))) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Código já cadastrado.");
                    }
                    break;

                case 7:
                    System.out.print("\nCódigo do produto a remover (ou '0' para voltar): ");
                    String codRem = scanner.nextLine();
                    if (codRem.equals("0")) break;
                    
                    if (estoque.verificarExistencia(codRem)) {
                        estoque.removerProduto(codRem);
                        System.out.println("Produto removido.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("\nCódigo do produto para reposição (ou '0' para voltar): ");
                    String codRepor = scanner.nextLine();
                    if (codRepor.equals("0")) break;

                    Produto pRepor = estoque.buscarProduto(codRepor);
                    if (pRepor != null) {
                        System.out.print("Quantidade a adicionar: ");
                        int qtdRepor = scanner.nextInt();
                        pRepor.adicionarEstoque(qtdRepor);
                        System.out.println("Estoque atualizado.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("\n-- ESTOQUE BAIXO --");
                    estoque.listarEstoqueBaixo();
                    break;

                case 10:
                    System.out.println("\nFinalizando...");
                    System.out.printf("Valor total da sua compra: R$%.2f\n", fatura.getTotal_Fatura());
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}