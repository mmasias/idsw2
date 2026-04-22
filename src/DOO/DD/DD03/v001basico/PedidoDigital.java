package DOO.DD.DD03.v001basico;

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
    public void aceptar(ProcesadorEnvios procesador) {
        procesador.procesarEnvioDigital(this); // Primer despacho: polimorfismo sobre Pedido
    }
}
