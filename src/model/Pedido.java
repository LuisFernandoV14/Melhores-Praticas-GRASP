package model;// model.Pedido.java

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nomeCliente;
    private List<ItemPedido> itens;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    /** PADRÃO GRASP 2: CREATOR (Criador)
     * Pergunta: Quem deve ser responsável por criar um objeto model.ItemPedido?
     * Resposta: A classe model.Pedido.
     * Motivo: Um model.ItemPedido é logicamente "contido" dentro de um model.Pedido.
     * O model.Pedido é o "agregador". Este método cria e armazena
     * a instância de model.ItemPedido que ele mesmo irá gerenciar.
     */

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        this.itens.add(novoItem);
    }

    /** PADRÃO GRASP 1: INFORMATION EXPERT (Especialista da Informação)
     * Pergunta: Quem é responsável por calcular o valor TOTAL do pedido?
     * Resposta: A classe model.Pedido.
     * Motivo: Ela é a "Especialista" que possui a informação
     * necessária (a lista de 'itens') para cumprir essa responsabilidade.
     */

    public double getValorTotal() {
        double total = 0.0;

        // O model.Pedido (Expert do total) colabora com o model.ItemPedido
        // (Expert do subtotal) para fazer o cálculo.
        for (ItemPedido item : this.itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Getters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}