package cu.edu.cujae.pweb.service;
import cu.edu.cujae.pweb.dto.SubjectDto;
import java.util.List;

public interface SubjectService {
	List<SubjectDto> getSubjects();
    void createSubject(SubjectDto subject);
    void updateSubject(SubjectDto subject);
    List<SubjectDto> getSubjectsByStudent(int codStudent);
    List<SubjectDto> getSubjectsEvaluatedByStudent(int codStudent);
    SubjectDto getSubjectById(int codSubject);
    void deleteSubject(int id);
}