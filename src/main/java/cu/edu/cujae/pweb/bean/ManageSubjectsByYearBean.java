package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.reportDto.StudentsByGroupDto;
import cu.edu.cujae.pweb.dto.reportDto.SubjectsByYearDto;
import cu.edu.cujae.pweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageSubjectsByYearBean {
    private List<SubjectsByYearDto> subjectsByYearList;

    @Autowired
    private ReportService reportService;

    public ManageSubjectsByYearBean() {
    }

    public List<SubjectsByYearDto> getSubjectsByYearList() {
        return reportService.getSubjectsByYear();
    }

    public void setSubjectsByYearList(List<SubjectsByYearDto> subjectsByYearList) {
        this.subjectsByYearList = subjectsByYearList;
    }
}

