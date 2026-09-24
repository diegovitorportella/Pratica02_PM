public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() { return nome; }
    public void setNome(String nome){ this.nome = nome; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo){ this.codigo = codigo; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco){ this.preco = preco; }
    
    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    public void adicionarEstoque(int valor) {
        this.quantidadeEstoque += valor;
    }

    public boolean retirarEstoque(int valor) {
        if (this.quantidadeEstoque >= valor) {
            this.quantidadeEstoque -= valor;
            return true;
        }
        return false;
    }
}