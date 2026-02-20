package vConDF;

class AppConDF {
    public static void main(String[] args) {
        Producto producto = new Producto("Laptop", 1000.0, 6);
        ProcesarVenta venta = new ProcesarVenta();
        if (venta.ejecutar(producto)) {
            System.out.println("Venta procesada con éxito");
        } else {
            System.out.println("No se pudo procesar la venta");
        }
    }

}
