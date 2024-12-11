package od.estudiantes.servicio;

import od.estudiantes.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiante> listarEstudiante();

    public  Estudiante buscarEstudiantePorId(Integer idEstudiante);

    public void  guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);
}
