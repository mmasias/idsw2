package DOO.DD.DD03.v002extensible;

public class ProcesadorEnvios implements VisitantePedido {

    public void procesar(Pedido pedido) {
        pedido.aceptar(this); // Delegación al pedido (primer despacho)
    }

    @Override
    public void visitar(PedidoFisico pedidoFisico) {
        System.out.printf("Enviando pedido físico %s a %s%n", pedidoFisico.getId(), pedidoFisico.getDireccionEnvio());
        System.out.printf("  Peso: %.2f kg, Coste envío: %.2f €%n", pedidoFisico.getPeso(), pedidoFisico.getPeso() * 2.5);
        System.out.printf("  Cliente: %s, Total: %.2f €%n", pedidoFisico.getCliente(), pedidoFisico.getTotal());
    }

    @Override
    public void visitar(PedidoDigital pedidoDigital) {
        System.out.printf("Enviando pedido digital %s a %s%n", pedidoDigital.getId(), pedidoDigital.getEmail());
        System.out.printf("  Generando enlace de descarga%n");
        System.out.printf("  Cliente: %s, Total: %.2f €%n", pedidoDigital.getCliente(), pedidoDigital.getTotal());
    }

    @Override
    public void visitar(PedidoSuscripcion pedidoSuscripcion) {
        System.out.printf("Activando suscripción %s%n", pedidoSuscripcion.getId());
        System.out.printf("  Duración: %d meses%n", pedidoSuscripcion.getDuracionMeses());
        System.out.printf("  Cliente: %s, Total: %.2f €%n", pedidoSuscripcion.getCliente(), pedidoSuscripcion.getTotal());
    }
}
