package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


import cu.edu.cujae.pweb.dto.*;
import cu.edu.cujae.pweb.service.DropStudentService;
import cu.edu.cujae.pweb.service.EstudiantesService;
import cu.edu.cujae.pweb.service.RecordService;
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
    private GroupDto grupo;



    @Autowired
    private EstudiantesService estudiantesService;
    @Autowired
    private DropStudentService dropStudentService;
    @Autowired
    private RecordService recordService;

    public ManageEstudiantesBean() {

    }




    public void openNew() {
        this.selectedEstudiantes = new StudentDto();
        this.selectedEstudiantes.setGender(new GenderDto());
        this.selectedEstudiantes.setMunicipality(new MunicipalityDto());
        this.grupo=new GroupDto();
        this.grupo.setYear(new YearDto());
    }


    public void openForEdit() {
      this.grupo=estudiantesService.getGroupByStudent(this.selectedEstudiantes.getCodStudent());
    }

    public void saveEstudiantes() {
        if (this.selectedEstudiantes.getCodStudent() == 0) {

            //register student
            estudiantesService.createEstudiantes(this.selectedEstudiantes);
            //register record
            recordService.createRecord(new RecordDto(this.grupo,this.selectedEstudiantes));

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiantes_added");
        } else {
            //edit student
            estudiantesService.updateEstudiantes(this.selectedEstudiantes);
            //edit record
            recordService.updateRecord(new RecordDto(this.grupo,this.selectedEstudiantes));

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiantes_edited");
        }

        //load datatable again with new values
        estudiantes = estudiantesService.getEstudiantes();
         PrimeFaces.current().executeScript("PF('manageEstudiantesDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-estudiantes");
    }

    public void deleteEstudiantes() {
        try {
            //delete student
            estudiantesService.deleteEstudiantes(this.selectedEstudiantes.getCodStudent());
            this.selectedEstudiantes = null;

            //load datatable again with new values
            estudiantes = estudiantesService.getEstudiantes();

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiantes_deleted");
            PrimeFaces.current().ajax().update("form:dt-estudiantes");
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
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

    public GroupDto getGrupo() {
        return grupo;
    }

    public void setGrupo(GroupDto grupo) {
        this.grupo = grupo;
    }
}
