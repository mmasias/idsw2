package vConDF;

class ValidarInventario {
    public boolean ejecutar(Producto producto) {
        return producto.getCantidad() > 0;
    }
}