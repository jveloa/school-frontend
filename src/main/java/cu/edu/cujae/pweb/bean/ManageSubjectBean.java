package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CourseDto;
import cu.edu.cujae.pweb.dto.SubjectDto;
import cu.edu.cujae.pweb.dto.YearDto;
import cu.edu.cujae.pweb.service.CourseService;
import cu.edu.cujae.pweb.service.SubjectService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
public class ManageSubjectBean {
    private List<SubjectDto> subjects;
    private SubjectDto selectedSubject;
    private SubjectDto subjectDto;
    private List<CourseDto> courses;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    public ManageSubjectBean() {
    }
    public List<CourseDto> getCourses() {
        courses = courseService.getCourses();
        return courses;
    }
    public List<SubjectDto> getSubjects() {
        subjects = subjectService.getSubjects();
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public void openNew() {
        this.selectedSubject = new SubjectDto();
        this.selectedSubject.setCodSubject(0);
        this.selectedSubject.setYear(new YearDto());
        this.selectedSubject.getYear().setCourse(new CourseDto());
    }

    public void saveSubject() {
        if (this.selectedSubject.getCodSubject() == 0) {
           subjectService.createSubject(this.selectedSubject);
           JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_added");
        } else {
            subjectService.updateSubject(this.selectedSubject);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_edited");
        }
        subjects = subjectService.getSubjects();
        PrimeFaces.current().executeScript("PF('manageSubjectDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-subjects");
    }

    public void deleteSubject() {
        try {
            subjectService.deleteSubject(selectedSubject.getCodSubject());
            this.selectedSubject = null;
            subjects = subjectService.getSubjects();
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_deleted");
            PrimeFaces.current().ajax().update("form:dt-subjects");
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }
    public SubjectDto getSelectedSubject() {
        return selectedSubject;
    }


    public void setSelectedSubject(SubjectDto selectedSubject) {
        this.selectedSubject = selectedSubject;
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

    public void openForEdit() {
    }
}
