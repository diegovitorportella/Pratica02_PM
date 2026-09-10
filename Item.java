public class Item {
    private Produto produto;
    private int quantidade;
    private double valor_total;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_total = produto.getPreco() * quantidade;     
    }

    public Produto getProduto() { return produto; }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.valor_total = this.produto.getPreco() * this.quantidade;
    }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valor_total = this.produto.getPreco() * this.quantidade;
    }

    public double getValor_Total() { return valor_total; }
}