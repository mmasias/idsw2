package vSinDF;

class Venta {
    private Producto producto;
    private double precioFinal;

    public Venta(Producto producto) {
        this.producto = producto;
        this.precioFinal = producto.calcularPrecioFinal();
    }

    public boolean procesar() {
        if (!producto.tieneStock()) {
            return false;
        }

        producto.reducirStock();
        generarFactura();
        return true;
    }

    private void generarFactura() {
        System.out.println("Factura generada para: " + producto.getNombre());
        System.out.println("Precio final: " + precioFinal);
    }
}