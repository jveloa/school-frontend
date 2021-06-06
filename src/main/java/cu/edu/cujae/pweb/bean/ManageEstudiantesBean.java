package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import cu.edu.cujae.pweb.dto.EstudiantesDto;
import cu.edu.cujae.pweb.service.EstudiantesService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.utils.JsfUtils;


@Component
@ManagedBean
@ViewScoped
public class ManageEstudiantesBean {
    private EstudiantesDto estudiantesDto;
    private EstudiantesDto selectedEstudiantes;
    private List<EstudiantesDto> estudiantes;


    @Autowired
    private EstudiantesService estudiantesService;



    public ManageEstudiantesBean() {

    }


   /* @PostConstruct
    public void init() {
        estudiantes = estudiantes == null ? estudiantesService.getEstudiantes(): estudiantes;

    }*/

    public void openNew() {
        this.selectedEstudiantes = new EstudiantesDto();

    }


    public void openForEdit() {

    }

    public void saveEstudiantes() {
        PrimeFaces.current().ajax().update("form:dt-estudiantes");
    }

    public void deleteEstudiantes() {

    }

    public EstudiantesDto getEstudiantesDto() {
        return estudiantesDto;
    }

    public void setEstudiantesDto(EstudiantesDto estudiantesDto) {
        this.estudiantesDto = estudiantesDto;
    }

    public EstudiantesDto getSelectedEstudiantes() {
        return selectedEstudiantes;
    }

    public void setSelectedEstudiantes(EstudiantesDto selectedEstudiantes) {
        this.selectedEstudiantes = selectedEstudiantes;
    }

    public List<EstudiantesDto> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudiantesDto> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public EstudiantesService getEstudiantesService() {
        return estudiantesService;
    }

    public void setEstudiantesService(EstudiantesService estudiantesService) {
        this.estudiantesService = estudiantesService;
    }
}
