package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.reportDto.EvalByGroupDto;
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
public class ManageEvalByGroupDto {
    private List<EvalByGroupDto> evalByGroupDtoList;

    @Autowired
    private ReportService reportService;

    public ManageEvalByGroupDto() {

    }

    public List<EvalByGroupDto> getEvalByGroupDtoList() {
        return reportService.getEvalByGroup();
    }

    public void setEvalByGroupDtoList(List<EvalByGroupDto> evalByGroupDtoList) {
        this.evalByGroupDtoList = evalByGroupDtoList;
    }
}
