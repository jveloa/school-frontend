package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.SubjectDto;
import cu.edu.cujae.pweb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
public class ManageSubjectBean {
    private List<SubjectDto> Subjects;
    private SubjectDto selectedSubject;
    private SubjectDto SubjectDto;

    @Autowired
    private SubjectService subjectService;

    public ManageSubjectBean() {
    }

   /* @PostConstruct
    public void init() {
        Subjects = Subjects == null ? SubjectService.getSubjects() : Subjects;
    }*/

    public List<SubjectDto> getSubjects() {
        return Subjects;
    }

    public void setSubjects(List<SubjectDto> Subjects) {
        this.Subjects = Subjects;
    }

    public void openNew() {
        selectedSubject = new SubjectDto();
    }

    public void openForEdit() {

    }

    public SubjectDto getSelectedSubject() {
        return selectedSubject;
    }


    public void setSelectedSubject(SubjectDto selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public SubjectDto getSubjectDto() {
        return SubjectDto;
    }

    public void setSubjectDto(SubjectDto SubjectDto) {
        this.SubjectDto = SubjectDto;
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