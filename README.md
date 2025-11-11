# Justificativa de Design (GRASP & MVC)

Este projeto demonstra a separação de responsabilidades usando a arquitetura **MVC** como base e os princípios **GRASP** para alocar responsabilidades dentro do Modelo.


## 1. Padrão Arquitetural: Model-View-Controller (MVC)

O MVC foi usado para desacoplar a lógica de negócio (Model) da interface do usuário (View) e da coordenação de eventos (Controller).

* **Model**: `Pedido`, `ItemPedido`, `Produto`.
    * Contém os dados brutos e as regras de negócio. É aqui que os padrões GRASP são aplicados.
* **View**: `PedidoView`.
    * Responsável unicamente por renderizar os dados do Modelo para o usuário (neste caso, imprimindo no console). Não contém lógica de cálculo, promovendo **Alta Coesão**.
* **Controller**: `PedidoController`.
    * Atua como o maestro. Recebe a entrada (a "ação"), coordena o Modelo (manda o `Pedido` criar itens) e, por fim, seleciona a View para exibir o resultado.


## 2. Padrão GRASP: Information Expert (Especialista da Informação)

O princípio do Especialista define que a responsabilidade deve ser alocada à classe que possui a informação necessária para cumpri-la.

* **Onde**:
    * `ItemPedido.getSubtotal()`
    * `Pedido.getValorTotal()`
* **Por quê**:
    * `ItemPedido` é o especialista em seu próprio subtotal, pois ele é o único que conhece seu `Produto` (para saber o preço)


## 3. Padrão GRASP: Creator (Criador)

Este padrão define quem deve ser responsável por criar (instanciar) novos objetos.

* **Onde**: `Pedido.adicionarItem(Produto, int)`
* **Por quê**: O `Pedido` é responsável por criar instâncias de `ItemPedido`. Isso está correto porque a classe `Pedido` "agrega" (ou "contém") os objetos `ItemPedido`. O ciclo de vida do `ItemPedido` está intimamente ligado ao do `Pedido`.


## 4. Padrão GRASP: Controller (Controlador)

Este padrão GRASP é a base do 'C' no MVC e define quem deve receber e coordenar os eventos da "camada de sistema".

* **Onde**: A classe `PedidoController`.
* **Por quê**: O `PedidoController` atua como o ponto de entrada que recebe o evento do "mundo real" (no nosso caso, a chamada do `main()`). Ele não faz o trabalho de negócio, mas **delega** esse trabalho aos especialistas (o Modelo). Isso promove **Baixo Acoplamento** entre a camada de "interface" e a lógica de negócio.


### Desenvolvedores:
Leydson Douglas Góes de Araújo Praseres <br>
Luís Fernando Ventura Ferreira <br>


Obrigado por ler até aqui
