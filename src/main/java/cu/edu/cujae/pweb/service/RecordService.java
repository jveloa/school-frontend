package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.RecordDto;

import java.util.List;

public interface RecordService {
    List<RecordDto> getEstudiantes();
    void createRecord(RecordDto record);
    void updateRecord(RecordDto record);
}
