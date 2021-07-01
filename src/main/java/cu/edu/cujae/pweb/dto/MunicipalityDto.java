package cu.edu.cujae.pweb.dto;

public class MunicipalityDto {
    private int codMunicipality;
    private String municipality;

    public MunicipalityDto() {
    }

    public MunicipalityDto(int codMunicipality, String municipality) {
        this.codMunicipality = codMunicipality;
        this.municipality = municipality;
    }

    public int getCodMunicipality() {
        return codMunicipality;
    }

    public void setCodMunicipality(int codMunicipality) {
        this.codMunicipality = codMunicipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
