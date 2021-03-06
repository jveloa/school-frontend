package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.reportDto.StudentsByGroupDto;
import cu.edu.cujae.pweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageStudentsByGroupBean {
    private List<StudentsByGroupDto> studentsByGroupDtoList;

    @Autowired
    private ReportService reportService;

    public ManageStudentsByGroupBean() {
    }

    public List<StudentsByGroupDto> getStudentsByGroupDtoList() {
        return reportService.getStudentByGroup();
    }

    public void setStudentsByGroupDtoList(List<StudentsByGroupDto> studentsByGroupDtoList) {
        this.studentsByGroupDtoList = studentsByGroupDtoList;
    }

}
