package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.reportDto.StudentForGroupDto;

import java.util.List;

public interface ReportService {
    List<StudentForGroupDto> getStudentForGroup();
}
