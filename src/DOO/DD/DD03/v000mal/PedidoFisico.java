package DOO.DD.DD03.v000mal;

public class PedidoFisico extends Pedido {
    private String direccionEnvio;
    private double peso;

    public PedidoFisico(String id, String cliente, double total, String direccionEnvio, double peso) {
        super(id, cliente, total);
        this.direccionEnvio = direccionEnvio;
        this.peso = peso;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String getTipo() {
        return "FISICO";
    }
}
