package DOO.DD.DD03.v002extensible;

public interface VisitantePedido {
    void visitar(PedidoFisico pedido);
    void visitar(PedidoDigital pedido);
    void visitar(PedidoSuscripcion pedido);
}
