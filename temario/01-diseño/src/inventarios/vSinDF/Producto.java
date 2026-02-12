package vSinDF;

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public boolean tieneStock() {
        return cantidad > 0;
    }

    public void reducirStock() {
        cantidad--;
    }

    public double calcularPrecioFinal() {
        if (cantidad > 5) {
            return precio * 0.9;
        }
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
