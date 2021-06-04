package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.EstudiantesDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.*;
@Service
public class EstudiantesServicelmpl implements EstudiantesService{

    public List<EstudiantesDto> getEstudiantes() {
        List<EstudiantesDto>  estudiantes = new ArrayList<>();
        estudiantes.add(new EstudiantesDto(randomUUID().toString().replaceAll("-", "").substring(0, 9),"Pepito", "M", "31", "Playa"));
        estudiantes.add(new EstudiantesDto(randomUUID().toString().replaceAll("-", "").substring(0, 9),"Rodolfo", "M", "31", "Vedado"));
        estudiantes.add(new EstudiantesDto(randomUUID().toString().replaceAll("-", "").substring(0, 9),"Juan", "M", "31", "Playa"));
        estudiantes.add(new EstudiantesDto(randomUUID().toString().replaceAll("-", "").substring(0, 9),"Paco", "M", "31", "Vedado"));


        return estudiantes;
    }

    public EstudiantesDto getEstudiantesById(String estudiantesId) {
        return getEstudiantes().stream().filter(r -> r.getId().equals(estudiantesId)).findFirst().get();
    }

    @Override
    public void createEstudiantes(EstudiantesDto estudiante) {

    }

    @Override
    public void updateEstudiantes(EstudiantesDto estudiante) {
           this.getEstudiantes().add(estudiante);
    }

    @Override
    public void deleteEstudiantes(String id) {

    }




}
