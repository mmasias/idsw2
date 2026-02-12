package vConDF;

class CalcularPrecio {
    public void ejecutar(Producto producto) {
        double precioFinal = producto.getPrecio();
        if (producto.getCantidad() > 5) {
            precioFinal = precioFinal * 0.9;
        }
        producto.setPrecio(precioFinal);
    }
}