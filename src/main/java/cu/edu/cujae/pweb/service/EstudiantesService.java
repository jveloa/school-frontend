package cu.edu.cujae.pweb.service;
import java.util.List;

import cu.edu.cujae.pweb.dto.EstudiantesDto;


public interface EstudiantesService {

        List<EstudiantesDto> getEstudiantes();
        EstudiantesDto getEstudiantesById(String estudianteId);
        void createEstudiantes(EstudiantesDto estudiante);
        void updateEstudiantes(EstudiantesDto estudiante);
        void deleteEstudiantes(String id);

}
