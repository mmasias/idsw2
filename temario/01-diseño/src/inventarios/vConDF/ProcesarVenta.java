package vConDF;

class ProcesarVenta {
    private ValidarInventario validador;
    private CalcularPrecio calculador;
    private ActualizarInventario actualizador;
    private GenerarFactura generador;

    public ProcesarVenta() {
        validador = new ValidarInventario();
        calculador = new CalcularPrecio();
        actualizador = new ActualizarInventario();
        generador = new GenerarFactura();
    }

    public boolean ejecutar(Producto producto) {
        if (validador.ejecutar(producto)) {
            calculador.ejecutar(producto);
            actualizador.ejecutar(producto);
            generador.ejecutar(producto);
            return true;
        }
        return false;
    }
}