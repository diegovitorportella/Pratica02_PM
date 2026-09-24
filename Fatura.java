import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private ArrayList<Item> itens;
    private double total_fatura;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.total_fatura = 0.0;
    }

    public void adicionarItem(Item item){
        this.itens.add(item);
        atualizarValorTotalFatura();
    }

    public void removerItem(int indice){
        if(indice >= 0 && indice < this.itens.size()){
            this.itens.remove(indice);
            atualizarValorTotalFatura();
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Índice de item inválido.");
        }
    }

    public void atualizarValorTotalFatura() {
        this.total_fatura = 0.0;
        for (Item item : this.itens) {
            this.total_fatura += item.getValor_Total();
        }
    }

    public Item getItem(int indice) {
        if(indice >= 0 && indice < this.itens.size()){
            return this.itens.get(indice);
        }
        return null;
    }

    public List<Item> getItens() { return itens; }
    public double getTotal_Fatura() { return total_fatura; }
}