package cu.edu.cujae.pweb.dto;

public class StudentDto {
    private int codStudent;
    private String name;
    private String lastName;
    private GenderDto gender;
    private MunicipalityDto municipality;

    public StudentDto() {
    }

    public StudentDto(int codStudent, String name, String lastName, GenderDto gender, MunicipalityDto municipality) {
        this.codStudent = codStudent;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.municipality = municipality;
    }

    public StudentDto(int codStudent) {
        this.codStudent = codStudent;
    }

    public int getCodStudent() {
        return codStudent;
    }

    public void setCodStudent(int codStudent) {
        this.codStudent = codStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderDto getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }

    public MunicipalityDto getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDto municipality) {
        this.municipality = municipality;
    }
}
