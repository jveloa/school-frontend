package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.DropStudentDto;

import java.util.List;

public interface DropStudentService {
    List<DropStudentDto> getBajas();
    void createDropStudent(DropStudentDto baja);
    void updateDropStudent(DropStudentDto baja);
    void deleteDropStudent(int codEst);


}
