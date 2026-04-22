package DOO.DD.DD03.v000mal;

public abstract class Pedido {
    protected String id;
    protected String cliente;
    protected double total;

    public Pedido(String id, String cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public abstract String getTipo();
}
