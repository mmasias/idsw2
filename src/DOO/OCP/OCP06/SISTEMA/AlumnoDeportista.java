package DOO.OCP.OCP06.SISTEMA;

public class AlumnoDeportista extends Alumno {
    private String deporte;
    private String nivelCompeticion;

    public AlumnoDeportista(String id, String nombre, String email,
                            String deporte, String nivelCompeticion) {
        super(id, nombre, email);
        this.deporte = deporte;
        this.nivelCompeticion = nivelCompeticion;
    }

    public String getDeporte() { return deporte; }
    public String getNivelCompeticion() { return nivelCompeticion; }

    @Override
    public void solicitarBeca(EvaluadorBecas evaluador) {
        evaluador.evaluar(this);
    }
}
