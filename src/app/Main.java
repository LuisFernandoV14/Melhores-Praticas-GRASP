package app;

import controller.PedidoController;
import view.PedidoView;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Exemplo de MVC (sem Spring) ---");

        // Cria a View (Responsável pela saída)
        PedidoView view = new PedidoView();

        // Cria o Controller (Responsável pela lógica e injeta a view nele.
        PedidoController controller = new PedidoController(view);

        // Inicia a aplicação (O Controller assume o controle a partir daqui)
        controller.criarPedidoSimulado();
    }
}

/**
 * == JUSTIFICATIVA DE DESIGN (GRASP & MVC) ==
 *
 * Este código demonstra a separação de responsabilidades usando os padrões
 * arquiteturais MVC e os princípios GRASP.
 *
 * ---
 *
 * 1. Padrão Arquitetural: Model-View-Controller (MVC)
 *
 * O MVC foi usado para separar a lógica de negócio (Model) da
 * interface do usuário (View) e da coordenação (Controller).
 *
 * - [Model]: `Pedido`, `ItemPedido`, `Produto`.
 * Contêm os dados e as regras de negócio (onde os padrões GRASP
 * são aplicados).
 *
 * - [View]: `PedidoView`.
 * Responsável unicamente por renderizar os dados do Modelo.
 * Não contém lógica de cálculo, promovendo Alta Coesão (High Cohesion).
 *
 * - [Controller]: `PedidoController`.
 * Recebe a entrada, coordena o Modelo e manda a View exibir.
 * Não contém regras de negócio.
 *
 * ---
 *
 * 2. Padrão GRASP: Information Expert (Especialista da Informação)
 *
 * - [Onde]: `ItemPedido.getSubtotal()` e `Pedido.getValorTotal()`.
 *
 * - [Por quê]: O princípio do Especialista define que a responsabilidade
 * deve ser alocada à classe que possui a informação necessária
 * para cumpri-la.
 *
 * - `ItemPedido` é o especialista em seu subtotal, pois conhece
 * o 'produto' (preço) e a 'quantidade'.
 * - `Pedido` é o especialista no valor total, pois conhece
 * sua lista de 'itens'. Ele colabora com os outros especialistas
 * (os ItemPedido) para calcular o total.
 *
 * ---
 *
 * 3. Padrão GRASP: Creator (Criador)
 *
 * - [Onde]: `Pedido.adicionarItem(Produto, int)`.
 *
 * - [Por quê]: O `Pedido` é responsável por criar instâncias de `ItemPedido`.
 * Essa escolha atende ao padrão Creator porque a classe `Pedido`
 * "agrega" (ou "contém") os objetos `ItemPedido`. O ciclo de vida
 * do `ItemPedido` está intimamente ligado ao do `Pedido`.
 *
 * ---
 *
 * 4. Padrão GRASP: Controller (Controlador)
 *
 * - [Onde]: A classe `PedidoController`.
 *
 * - [Por quê]: Este padrão GRASP é a base do 'C' no MVC. O `PedidoController`
 * atua como o ponto de entrada que recebe o evento do "mundo real"
 * (neste caso, a chamada do `main()`).
 *
 * Ele não faz o trabalho de negócio, mas *delega* esse trabalho
 * aos especialistas (o Modelo). Isso promove Baixo Acoplamento
 * (Low Coupling) entre a camada de "interface" e a lógica de negócio.
 *
 */