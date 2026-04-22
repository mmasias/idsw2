package DOO.DD.DD03.v002extensible;

public class ProcesadorFacturacion implements VisitantePedido {

    public void procesar(Pedido pedido) {
        pedido.aceptar(this);
    }

    @Override
    public void visitar(PedidoFisico pedidoFisico) {
        System.out.printf("Facturando pedido físico %s%n", pedidoFisico.getId());
        System.out.printf("  Concepto: Productos físicos + Envío%n");
        System.out.printf("  Base imponible: %.2f €, IVA: %.2f €, Total: %.2f €%n",
                          pedidoFisico.getTotal(), pedidoFisico.getTotal() * 0.21, pedidoFisico.getTotal() * 1.21);
    }

    @Override
    public void visitar(PedidoDigital pedidoDigital) {
        System.out.printf("Facturando pedido digital %s%n", pedidoDigital.getId());
        System.out.printf("  Concepto: Productos digitales%n");
        System.out.printf("  Base imponible: %.2f €, IVA: %.2f €, Total: %.2f €%n",
                          pedidoDigital.getTotal(), pedidoDigital.getTotal() * 0.21, pedidoDigital.getTotal() * 1.21);
    }

    @Override
    public void visitar(PedidoSuscripcion pedidoSuscripcion) {
        System.out.printf("Facturando suscripción %s%n", pedidoSuscripcion.getId());
        System.out.printf("  Concepto: Suscripción de %d meses%n", pedidoSuscripcion.getDuracionMeses());
        System.out.printf("  Base imponible: %.2f €/mes, IVA: %.2f €, Total: %.2f €%n",
                          pedidoSuscripcion.getTotal() / pedidoSuscripcion.getDuracionMeses(),
                          (pedidoSuscripcion.getTotal() / pedidoSuscripcion.getDuracionMeses()) * 0.21,
                          pedidoSuscripcion.getTotal());
    }
}
