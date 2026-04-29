package DOO.OCP.OCP07.SISTEMA;

public class AlumnoHonorario extends Alumno {

    public AlumnoHonorario(String id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public void solicitarBeca(EvaluadorBecas evaluador) {
        throw new UnsupportedOperationException("Los alumnos honorarios no solicitan becas");
    }
}
