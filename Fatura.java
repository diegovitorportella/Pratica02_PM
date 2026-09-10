import java.util.ArrayList;
import java.util.list;

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
        }else{
            System.out.println("Índice de item inválido.");
        }    
    }


    public List<Item> getItens() { return itens; }
    public double getTotal_Fatura() { return total_fatura; }
}