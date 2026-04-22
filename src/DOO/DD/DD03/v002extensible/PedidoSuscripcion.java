package DOO.DD.DD03.v002extensible;

public class PedidoSuscripcion extends Pedido {
    private int duracionMeses;

    public PedidoSuscripcion(String id, String cliente, double total, int duracionMeses) {
        super(id, cliente, total);
        this.duracionMeses = duracionMeses;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    @Override
    public void aceptar(VisitantePedido visitante) {
        visitante.visitar(this); // Primer despacho: polimorfismo sobre Pedido
    }
}
