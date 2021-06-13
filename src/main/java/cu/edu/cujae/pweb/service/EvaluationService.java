package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.EvaluationDto;
import cu.edu.cujae.pweb.dto.StudentDto;

import java.util.List;

public interface EvaluationService {

    List<EvaluationDto> getNotas(StudentDto student);
    List<List<String>> getNotasTest();
    // NotaDto getNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante);
    void createNota(EvaluationDto nota);
    void updateNota(EvaluationDto nota);
    void deleteNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante);
}
