package DOO.DD.DD03.v000mal;

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
    public String getTipo() {
        return "DIGITAL";
    }
}
