package controller;

import model.Pedido;
import model.Produto;
import view.PedidoView;

public class PedidoController {

    private PedidoView view;

    public PedidoController(PedidoView view) {
        this.view = view;
    }

    public void criarPedidoSimulado() {

        Produto caneta = new Produto("Caneta Azul", 2.50);
        Produto caderno = new Produto("Caderno 10 Matérias", 35.90);

        Pedido meuPedido = new Pedido("Cliente Vítor");

        meuPedido.adicionarItem(caneta, 4);
        meuPedido.adicionarItem(caderno, 1);

        this.view.exibirDetalhes(meuPedido);
    }
}