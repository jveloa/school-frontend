package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.SubjectDto;
import cu.edu.cujae.pweb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
public class ManageSubjectBean {
    private List<SubjectDto> subjects;
    private SubjectDto selectedsubject;
    private SubjectDto subjectDto;

    @Autowired
    private SubjectService subjectService;

    public ManageSubjectBean() {
    }
    /*
    @PostConstruct
    public void init() {
        subjects = subjects == null ? subjectService.getSubjects() : subjects;
    }*/

    public List<SubjectDto> getSubjects() {
        subjects = subjectService.getSubjects();
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public void openNew() {
        selectedsubject = new SubjectDto();
    }

    public void openForEdit() {

    }

    public SubjectDto getSelectedsubject() {
        return selectedsubject;
    }


    public void setSelectedsubject(SubjectDto selectedsubject) {
        this.selectedsubject = selectedsubject;
    }

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto SubjectDto) {
        this.subjectDto = SubjectDto;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public void saveSubject() {

    }
}