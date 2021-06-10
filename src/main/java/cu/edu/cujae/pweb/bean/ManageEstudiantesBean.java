package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.service.EstudiantesService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.utils.JsfUtils;


@Component
@ManagedBean
@ViewScoped
public class ManageEstudiantesBean {
    private StudentDto estudiantesDto;
    private StudentDto selectedEstudiantes;
    private List<StudentDto> estudiantes;


    @Autowired
    private EstudiantesService estudiantesService;



    public ManageEstudiantesBean() {

    }


   /* @PostConstruct
    public void init() {
        estudiantes = estudiantesService.getEstudiantes();

    }*/

    public void openNew() {
        this.selectedEstudiantes = new StudentDto();

    }


    public void openForEdit() {

    }

    public void saveEstudiantes() {
        PrimeFaces.current().ajax().update("form:dt-estudiantes");
    }

    public void deleteEstudiantes() {

    }

    public StudentDto getEstudiantesDto() {
        return estudiantesDto;
    }

    public void setEstudiantesDto(StudentDto estudiantesDto) {
        this.estudiantesDto = estudiantesDto;
    }

    public StudentDto getSelectedEstudiantes() {
        return selectedEstudiantes;
    }

    public void setSelectedEstudiantes(StudentDto selectedEstudiantes) {
        this.selectedEstudiantes = selectedEstudiantes;
    }

    public List<StudentDto> getEstudiantes() {
        estudiantes= estudiantesService.getEstudiantes();
        return estudiantes;
    }

    public void setEstudiantes(List<StudentDto> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public EstudiantesService getEstudiantesService() {
        return estudiantesService;
    }

    public void setEstudiantesService(EstudiantesService estudiantesService) {
        this.estudiantesService = estudiantesService;
    }
}
