package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.DropStudentDto;
import cu.edu.cujae.pweb.dto.ReasonDropDto;
import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.service.DropStudentService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
@Component
@ManagedBean
@ViewScoped
public class ManageDropStudentBean {

    private DropStudentDto dropStudent;
    private  DropStudentDto selectedDropStudent=new DropStudentDto(new ReasonDropDto(),new StudentDto());
    private List<DropStudentDto> dropStudentDtoList;
    private StudentDto selectedStudent;



    @Autowired
    DropStudentService dropStudentService;

    public ManageDropStudentBean(){

    }
    public void openNew (){
       this.selectedDropStudent=new DropStudentDto();
        this.selectedDropStudent.setStudent(new StudentDto());
        this.selectedDropStudent.setReasonDrop(new ReasonDropDto());

    }
    public void openForEdit() {

    }
    public String saveDropStudent() {
        String result=null;
        if (this.selectedDropStudent.getStudent().getCodStudent() == 0) {

            //register dropStudent
            this.selectedDropStudent.getStudent().setCodStudent(this.selectedStudent.getCodStudent());
            dropStudentService.createDropStudent(this.selectedDropStudent);

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_baja_added");
            result="atras";
        } else {
            //edit dropStudent

            dropStudentService.updateDropStudent(this.selectedDropStudent);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_baja_edited");
        }

        //load datatable again with new values
        dropStudentDtoList = dropStudentService.getBajas();
        //PrimeFaces.current().executeScript("PF('manageEstudiantesDialog').hide()");
       // PrimeFaces.current().ajax().update("form:dt-estudiantes");
        return result;
    }

    public String deleteEstudiantes() {
        String result=null;
        try {
            this.selectedDropStudent.getStudent().setCodStudent(this.selectedStudent.getCodStudent());
            //delete student
            dropStudentService.deleteDropStudent(this.selectedDropStudent.getStudent().getCodStudent());
            this.selectedDropStudent = new DropStudentDto();


            //load datatable again with new values
            dropStudentDtoList = dropStudentService.getBajas();

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_baja_deleted");
            //PrimeFaces.current().ajax().update("form:dt-estudiantes");
            result="atras";
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
        return result;
    }

    public DropStudentDto getDropStudent() {
        return dropStudent;
    }

    public void setDropStudent(DropStudentDto dropStudent) {
        this.dropStudent = dropStudent;
    }

    public DropStudentDto getSelectedDropStudent() {
        return selectedDropStudent;
    }

    public void setSelectedDropStudent(DropStudentDto selectedDropStudent) {
        this.selectedDropStudent = selectedDropStudent;
    }

    public List<DropStudentDto> getDropStudentDtoList() {
        dropStudentDtoList=dropStudentService.getBajas();
        return dropStudentDtoList;
    }

    public void setDropStudentDtoList(List<DropStudentDto> dropStudentDtoList) {
        this.dropStudentDtoList = dropStudentDtoList;
    }

    public StudentDto getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentDto selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
    public String siOnoBaja(){
        List<DropStudentDto>bajas=dropStudentService.getBajas();
        boolean control=false;
        String result;
        int i=0;
        while (i<bajas.size() && control==false){
            if(bajas.get(i).getStudent().getCodStudent()==selectedStudent.getCodStudent()){
                control=true;
            }
            i++;
        }
        if (control == true) {
            result="esBaja";
        }else {
            result="noBaja";
        }
        return result;
    }

}
