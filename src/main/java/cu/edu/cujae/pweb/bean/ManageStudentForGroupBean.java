package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.reportDto.StudentForGroupDto;
import cu.edu.cujae.pweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageStudentForGroupBean {
    private List<StudentForGroupDto> studentForGroupDtoList;
    private StudentForGroupDto selectedStudent;

    @Autowired
    private ReportService reportService;

    public ManageStudentForGroupBean() {
    }

    public void openNew() {
        this.selectedStudent = new StudentForGroupDto();
    }

    public List<StudentForGroupDto> getStudentForGroupDtoList() {
        return reportService.getStudentForGroup();
    }

    public void setStudentForGroupDtoList(List<StudentForGroupDto> studentForGroupDtoList) {
        this.studentForGroupDtoList = studentForGroupDtoList;
    }

    public StudentForGroupDto getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentForGroupDto selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
}
