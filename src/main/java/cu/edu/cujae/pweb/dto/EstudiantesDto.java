package cu.edu.cujae.pweb.dto;
import java.util.List;
public class EstudiantesDto {


    private String id;
    private String nombre;
    private String sexo;
    private String grupo;
    private String municipio;
    public EstudiantesDto() {
        super();}
    public EstudiantesDto(String id, String nombre, String sexo, String grupo, String municipio) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.grupo = grupo;
        this.municipio = municipio;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


}
