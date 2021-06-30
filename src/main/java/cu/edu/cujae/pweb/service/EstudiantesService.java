package cu.edu.cujae.pweb.service;
import java.util.List;


import cu.edu.cujae.pweb.dto.GroupDto;
import cu.edu.cujae.pweb.dto.StudentDto;


public interface EstudiantesService {

        List<StudentDto> getEstudiantes();
        StudentDto getEstudiantesById(String estudianteId);
        void createEstudiantes(StudentDto estudiante);
        void updateEstudiantes(StudentDto estudiante);
        void deleteEstudiantes(int id);
        GroupDto getGroupByStudent(int codEst);

}
