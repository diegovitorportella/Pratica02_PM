import java.util.HashMap;

public class Estoque {
    private HashMap<String, Produto> produtos;
    private int tamanho;

    public Estoque() {
        this.produtos = new HashMap<>();
        this.tamanho = 0;
    }

    public boolean adicionarProduto(Produto p) {
        if (this.produtos.containsKey(p.getCodigo())) {
            return false;
        }
        this.produtos.put(p.getCodigo(), p);
        this.tamanho = this.produtos.size();
        return true;
    }

    public Produto buscarProduto(String codigo) {
        return this.produtos.get(codigo);
    }

    public void removerProduto(String codigo) {
        this.produtos.remove(codigo);
        this.tamanho = this.produtos.size();
    }

    public boolean verificarExistencia(String codigo) {
        return this.produtos.containsKey(codigo);
    }

    public void listarProdutos() {
        if (this.produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        for (Produto p : this.produtos.values()) {
            System.out.printf("Cód: %s | %s | R$%.2f | Estoque: %d\n", 
                p.getCodigo(), p.getNome(), p.getPreco(), p.getQuantidadeEstoque());
        }
    }
    
    public void listarEstoqueBaixo() {
        boolean encontrou = false;
        for (Produto p : this.produtos.values()) {
            if (p.getQuantidadeEstoque() < 5) {
                System.out.printf("Cód: %s | %s | Estoque: %d\n", 
                    p.getCodigo(), p.getNome(), p.getQuantidadeEstoque());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum produto com estoque abaixo de 5 unidades.");
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }
}