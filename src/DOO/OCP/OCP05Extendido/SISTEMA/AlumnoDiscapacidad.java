package DOO.OCP.OCP05Extendido.SISTEMA;

public class AlumnoDiscapacidad extends Alumno {
    private int porcentajeDiscapacidad;

    public AlumnoDiscapacidad(String id, String nombre, String email, int porcentajeDiscapacidad) {
        super(id, nombre, email);
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public int getPorcentajeDiscapacidad() { return porcentajeDiscapacidad; }

    @Override
    public void solicitarBeca(EvaluadorBecas evaluador) {
        evaluador.evaluar(this);
    }
}
