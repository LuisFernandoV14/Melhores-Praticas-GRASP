package model;

// model.ItemPedido.java
public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return this.produto.getPreco() * this.quantidade;
    }

    // Getters para exibição
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

}

/**  PADRÃO GRASP 1: INFORMATION EXPERT (Especialista da Informação)
 * A classe model.ItemPedido é a única classe que tem toda a informação necessária para calcular o preço total de itens repetidos de um pedido.
 */