package DOO.DD.DD03.v002extensible;

public class ProcesadorNotificaciones implements VisitantePedido {

    public void procesar(Pedido pedido) {
        pedido.aceptar(this);
    }

    @Override
    public void visitar(PedidoFisico pedidoFisico) {
        System.out.printf("Enviando notificación de pedido físico %s%n", pedidoFisico.getId());
        System.out.printf("  Destinatario: %s (correo postal)%n", pedidoFisico.getCliente());
        System.out.printf("  Mensaje: Su pedido ha sido enviado a %s%n", pedidoFisico.getDireccionEnvio());
    }

    @Override
    public void visitar(PedidoDigital pedidoDigital) {
        System.out.printf("Enviando notificación de pedido digital %s%n", pedidoDigital.getId());
        System.out.printf("  Destinatario: %s (email)%n", pedidoDigital.getEmail());
        System.out.printf("  Mensaje: Sus productos están disponibles en su cuenta%n");
    }

    @Override
    public void visitar(PedidoSuscripcion pedidoSuscripcion) {
        System.out.printf("Enviando notificación de suscripción %s%n", pedidoSuscripcion.getId());
        System.out.printf("  Destinatario: %s (email)%n", pedidoSuscripcion.getCliente());
        System.out.printf("  Mensaje: Su suscripción ha sido activada por %d meses%n", pedidoSuscripcion.getDuracionMeses());
    }
}
