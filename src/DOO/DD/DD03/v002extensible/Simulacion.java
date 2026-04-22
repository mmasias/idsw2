package DOO.DD.DD03.v002extensible;

public class Simulacion {
    public static void main(String[] args) {
        Pedido[] pedidos = {
            new PedidoFisico("PED-001", "Juan Pérez", 150.0, "Calle Mayor 123, Madrid", 2.5),
            new PedidoDigital("PED-002", "María López", 25.0, "maria@ejemplo.com"),
            new PedidoSuscripcion("PED-003", "Carlos Ruiz", 200.0, 12)
        };

        ProcesadorEnvios procesadorEnvios = new ProcesadorEnvios();
        ProcesadorFacturacion procesadorFacturacion = new ProcesadorFacturacion();
        ProcesadorNotificaciones procesadorNotificaciones = new ProcesadorNotificaciones();

        System.out.println("Procesando Pedidos - Envíos");
        for (Pedido pedido : pedidos) {
            System.out.println();
            procesadorEnvios.procesar(pedido);
        }

        System.out.println("Procesando Pedidos - Facturación");
        for (Pedido pedido : pedidos) {
            System.out.println();
            procesadorFacturacion.procesar(pedido);
        }

        System.out.println("Procesando Pedidos - Notificaciones");
        for (Pedido pedido : pedidos) {
            System.out.println();
            procesadorNotificaciones.procesar(pedido);
        }
    }
}
