package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.NotaDto;

import java.util.List;

public interface NotaService {

    List<NotaDto> getNotas();
    List<List<String>> getNotasTest();
    // NotaDto getNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante);
    void createNota(NotaDto nota);
    void updateNota(NotaDto nota);
    void deleteNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante);
}
