package vConDF;

class ActualizarInventario {
    public void ejecutar(Producto producto) {
        producto.setCantidad(producto.getCantidad() - 1);
    }
}