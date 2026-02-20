package vSinDF;

class AppSinDF {
    public static void main(String[] args) {
        Producto producto = new Producto("Laptop", 1000.0, 6);
        Venta venta = new Venta(producto);
        if (venta.procesar()) {
            System.out.println("Venta procesada con éxito");
        } else {
            System.out.println("No se pudo procesar la venta");
        }
    }    
}
