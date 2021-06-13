package cu.edu.cujae.pweb.bean;

import com.sun.xml.internal.ws.binding.FeatureListUtil;
import cu.edu.cujae.pweb.dto.*;
import cu.edu.cujae.pweb.service.EvaluationService;
import cu.edu.cujae.pweb.service.RangeEvaluationService;
import cu.edu.cujae.pweb.service.SubjectService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ManagedBean
@ViewScoped
public class ManageNotaBean {

    private EvaluationDto notaDto;
    private EvaluationDto selectedNota;
    private List<EvaluationDto> notas;
    private List<String> notasValores;
    private List<RangeEvaluationDto> evaluations;
    private StudentDto selectedStudent;
    private List<SubjectDto> subjectBySelectedStudent;
    private List<SubjectDto> subjectsNotEvaluatedByStudent;


    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private RangeEvaluationService rangeEvaluationService;

    @Autowired
    private SubjectService subjectService;

    public ManageNotaBean(){
    }

    @PostConstruct
    public void init() {
       evaluations = rangeEvaluationService.getRangeEvaluation();
    }





    public void openNew() {
        this.selectedNota = new EvaluationDto();
        this.selectedNota.setRangeEvaluation(new RangeEvaluationDto());
        this.selectedNota.setStudent(new StudentDto());
        this.selectedNota.setSubject(new SubjectDto());
        this.selectedNota.setYear(new YearDto());
    }

    public void openForEdit() {
        //
    }

    public void saveNota() {

            if (this.selectedNota.getYear().getCodYear()==0) {
                this.selectedNota.getStudent().setCodStudent(selectedStudent.getCodStudent());
                this.selectedNota.getYear().setCodYear(subjectService.getSubjectById(selectedNota.getSubject().getCodSubject()).getYear().getCodYear());
                evaluationService.createNota(this.selectedNota);
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nota_added");
            } else {
                evaluationService.updateNota(this.selectedNota);
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nota_edited");
            }

            notas = evaluationService.getNotas(selectedStudent);
            PrimeFaces.current().executeScript("PF('manageNotaDialog').hide()");
            PrimeFaces.current().ajax().update("form:dt-notas");

    }

    public void deleteUser() {
        /*try {
            this.notasPrueba.remove(this.selectedNotaPrueba);
            this.selectedNotaPrueba = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_removed");
            PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
*/
    }

    public EvaluationDto getNotaDto() {
        return notaDto;
    }

    public void setNotaDto(EvaluationDto notaDto) {
        this.notaDto = notaDto;
    }

    public List<String> getNotasValores() {
        return notasValores;
    }

    public void setNotasValores(List<String> notasValores) {
        this.notasValores = notasValores;
    }

    public EvaluationDto getSelectedNota() {
        return selectedNota;
    }

    public void setSelectedNota(EvaluationDto selectedNota) {
        this.selectedNota = selectedNota;
    }

    public StudentDto getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentDto selectedStudent) {
        this.selectedStudent = selectedStudent;
    }


    private List<RangeEvaluationDto> getEvaluations(){

        return rangeEvaluationService.getRangeEvaluation();
    }

    public void setEvaluations(List<RangeEvaluationDto> evaluations){ this.evaluations = evaluations;}

    public List<EvaluationDto> getNotas() {
        return evaluationService.getNotas(selectedStudent);

    }

    public void setNotas(List<EvaluationDto> notas) {
        this.notas = notas;
    }

    public EvaluationService getNotaService() {
        return evaluationService;
    }

    public void setNotaService(EvaluationService notaService) {
        this.evaluationService = notaService;
    }


    public List<SubjectDto> getSubjectBySelectedStudent() {
        this.subjectBySelectedStudent = subjectService.getSubjectsByStudent(selectedStudent.getCodStudent());
        return subjectBySelectedStudent;
    }

    public void setSubjectBySelectedStudent(List<SubjectDto> subjectBySelectedStudent) {
        this.subjectBySelectedStudent = subjectBySelectedStudent;
    }

    public List<SubjectDto> getSubjectsNotEvaluatedByStudent() {
        List<SubjectDto> subjectsEvaluated = subjectService.getSubjectsEvaluatedByStudent(selectedStudent.getCodStudent());
        List<SubjectDto> subjectsNotEvaluated = new ArrayList<SubjectDto>();
        if(subjectsEvaluated.equals(this.getSubjectBySelectedStudent())){
            this.subjectsNotEvaluatedByStudent = new ArrayList<>();
        }
        else {
            ArrayList<Integer> subjectEvaluatedCode = new ArrayList<>();
            for(SubjectDto i : subjectsEvaluated){
                subjectEvaluatedCode.add(i.getCodSubject());
            }

            for(SubjectDto i : this.subjectBySelectedStudent){
                if(!subjectEvaluatedCode.contains(i.getCodSubject())){
                    subjectsNotEvaluated.add(i);
                }
            }


            this.subjectsNotEvaluatedByStudent = subjectsNotEvaluated;
        }
        return subjectsNotEvaluated;
    }

    public void setSubjectsNotEvaluatedByStudent(List<SubjectDto> subjectsNotEvaluatedByStudent) {
        this.subjectsNotEvaluatedByStudent = subjectsNotEvaluatedByStudent;
    }
}
