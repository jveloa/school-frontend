package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.reportDto.StudentsByGroupDto;

import java.util.List;

public interface ReportService {
    List<StudentsByGroupDto> getStudentForGroup();
}
