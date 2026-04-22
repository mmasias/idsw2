package DOO.DD.DD03.v001basico;

public class Simulacion {
    public static void main(String[] args) {
        ProcesadorEnvios procesador = new ProcesadorEnvios();

        Pedido[] pedidos = {
            new PedidoFisico("PED-001", "Juan Pérez", 150.0, "Calle Mayor 123, Madrid", 2.5),
            new PedidoDigital("PED-002", "María López", 25.0, "maria@ejemplo.com"),
            new PedidoSuscripcion("PED-003", "Carlos Ruiz", 200.0, 12)
        };

        System.out.println("Procesando Pedidos");
        for (Pedido pedido : pedidos) {
            System.out.println();
            procesador.procesar(pedido);
        }
    }
}
