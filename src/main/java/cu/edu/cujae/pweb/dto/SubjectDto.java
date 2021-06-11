package cu.edu.cujae.pweb.dto;

//Asignaturas
public class SubjectDto {
    private int codSubject;
    private int hours;
    private String nameSubject;
    private YearDto year;

    public SubjectDto() {
    }

    public SubjectDto(int codSubject, int hours, String nameSubject, YearDto year) {
        this.codSubject = codSubject;
        this.hours = hours;
        this.nameSubject = nameSubject;
        this.year = year;
    }

    public SubjectDto(int codSubject) {
        this.codSubject = codSubject;
    }

    public int getCodSubject() {
        return codSubject;
    }

    public void setCodSubject(int codSubject) {
        this.codSubject = codSubject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public YearDto getYear() {
        return year;
    }

    public void setYear(YearDto year) {
        this.year = year;
    }
}
