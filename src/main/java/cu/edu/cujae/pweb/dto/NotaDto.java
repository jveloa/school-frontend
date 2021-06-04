package cu.edu.cujae.pweb.dto;

public class NotaDto {

    private int codigo_asignatura;
    private int codigo_anno;
    private int codigo_estudiante;
    private int codigo_evaluacion;

    public NotaDto() {
        super();
    }

    public NotaDto(int codigo_asignatura, int codigo_anno, int codigo_estudiante, int codigo_evaluacion){
        this.codigo_asignatura = codigo_asignatura;
        this.codigo_anno = codigo_anno;
        this.codigo_estudiante = codigo_estudiante;
        this.codigo_evaluacion = codigo_evaluacion;
    }

    public int getCodigo_asignatura() {
        return codigo_asignatura;
    }

    public void setCodigo_asignatura(int codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }

    public int getCodigo_anno() {
        return codigo_anno;
    }

    public void setCodigo_anno(int codigo_anno) {
        this.codigo_anno = codigo_anno;
    }

    public int getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public void setCodigo_estudiante(int codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public int getCodigo_evaluacion() {
        return codigo_evaluacion;
    }

    public void setCodigo_evaluacion(int codigo_evaluacion) {
        this.codigo_evaluacion = codigo_evaluacion;
    }
}
