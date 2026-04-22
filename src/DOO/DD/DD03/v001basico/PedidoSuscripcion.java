package DOO.DD.DD03.v001basico;

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
    public void aceptar(ProcesadorEnvios procesador) {
        procesador.procesarActivacionSuscripcion(this); // Primer despacho: polimorfismo sobre Pedido
    }
}
