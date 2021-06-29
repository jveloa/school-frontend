package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.reportDto.StudentLadderDto;
import cu.edu.cujae.pweb.dto.reportDto.StudentsByGroupDto;
import cu.edu.cujae.pweb.dto.reportDto.SubjectsByYearDto;

import java.util.List;

public interface ReportService {
    List<StudentsByGroupDto> getStudentByGroup();

    List<SubjectsByYearDto> getSubjectsByYear();
    List<StudentLadderDto> getStudentLadderDtoList(String course,int year);

}
