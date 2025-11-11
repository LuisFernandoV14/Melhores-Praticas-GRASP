package view;

import model.ItemPedido;
import model.Pedido;

public class PedidoView {

    public void exibirDetalhes(Pedido pedido) {
        System.out.println("\n--- Detalhes do Pedido ---");
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Itens do Pedido:");

        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("  - %s (Qtd: %d) - Subtotal: R$ %.2f\n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.getSubtotal()
            );
        }

        System.out.printf("\nVALOR TOTAL DO PEDIDO: R$ %.2f\n",
                pedido.getValorTotal()
        );
    }
}