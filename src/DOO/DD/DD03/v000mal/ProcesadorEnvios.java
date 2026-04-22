package DOO.DD.DD03.v000mal;

public class ProcesadorEnvios {

    public void procesar(Pedido pedido) {
        if (pedido instanceof PedidoFisico) {
            PedidoFisico pedidoFisico = (PedidoFisico) pedido;
            procesarEnvioFisico(pedidoFisico);
        } else if (pedido instanceof PedidoDigital) {
            PedidoDigital pedidoDigital = (PedidoDigital) pedido;
            procesarEnvioDigital(pedidoDigital);
        } else if (pedido instanceof PedidoSuscripcion) {
            PedidoSuscripcion pedidoSuscripcion = (PedidoSuscripcion) pedido;
            procesarActivacionSuscripcion(pedidoSuscripcion);
        }
    }

    private void procesarEnvioFisico(PedidoFisico pf) {
        System.out.printf("Enviando pedido físico %s a %s%n", pf.getId(), pf.getDireccionEnvio());
        System.out.printf("  Peso: %.2f kg, Coste envío: %.2f €%n", pf.getPeso(), pf.getPeso() * 2.5);
        System.out.printf("  Cliente: %s, Total: %.2f €%n", pf.getCliente(), pf.getTotal());
    }

    private void procesarEnvioDigital(PedidoDigital pd) {
        System.out.printf("Enviando pedido digital %s a %s%n", pd.getId(), pd.getEmail());
        System.out.printf("  Generando enlace de descarga%n");
        System.out.printf("  Cliente: %s, Total: %.2f €%n", pd.getCliente(), pd.getTotal());
    }

    private void procesarActivacionSuscripcion(PedidoSuscripcion ps) {
        System.out.printf("Activando suscripción %s%n", ps.getId());
        System.out.printf("  Duración: %d meses%n", ps.getDuracionMeses());
        System.out.printf("  Cliente: %s, Total: %.2f €%n", ps.getCliente(), ps.getTotal());
    }
}
