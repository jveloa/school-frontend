package cu.edu.cujae.pweb.dto;

public class GenderDto {
    private int codGender;
    private String gender;

    public GenderDto() {
    }

    public GenderDto(int codGender, String gender) {
        this.codGender = codGender;
        this.gender = gender;
    }

    public int getCodGender() {
        return codGender;
    }

    public void setCodGender(int codGender) {
        this.codGender = codGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
