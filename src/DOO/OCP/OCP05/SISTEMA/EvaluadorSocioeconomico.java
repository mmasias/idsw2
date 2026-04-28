package DOO.OCP.OCP05.SISTEMA;

public class EvaluadorSocioeconomico implements EvaluadorBecas {

    @Override
    public void evaluar(Alumno alumno) {
        System.out.println("Renta familiar y situación económica: " + alumno.getNombre());
    }

    @Override
    public void evaluar(AlumnoErasmus alumnoErasmus) {
        System.out.println("Baremos internacionales (" + alumnoErasmus.getPaisOrigen() + "): " + alumnoErasmus.getNombre());
    }

    @Override
    public void evaluar(AlumnoVirtual alumnoVirtual) {
        System.out.println("Costes de conectividad y equipamiento: " + alumnoVirtual.getNombre());
    }
}
