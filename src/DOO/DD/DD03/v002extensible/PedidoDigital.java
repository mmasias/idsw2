package DOO.DD.DD03.v002extensible;

public class PedidoDigital extends Pedido {
    private String email;

    public PedidoDigital(String id, String cliente, double total, String email) {
        super(id, cliente, total);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void aceptar(VisitantePedido visitante) {
        visitante.visitar(this); // Primer despacho: polimorfismo sobre Pedido
    }
}
