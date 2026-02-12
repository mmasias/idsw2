package vConDF;

class GenerarFactura {
    public void ejecutar(Producto producto) {
        System.out.println("Factura generada para: " + producto.getNombre());
        System.out.println("Precio final: " + producto.getPrecio());
    }
}