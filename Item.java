public class Item {
    private Produto produto;
    private int quantidade;
    private double valor_total;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        atualizarValor();
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) {
        this.produto = produto;
        atualizarValor();
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        atualizarValor();
    }

    public double getValor_Total() { return valor_total; }

    private void atualizarValor() {
        this.valor_total = this.produto.getPreco() * this.quantidade;
    }
}