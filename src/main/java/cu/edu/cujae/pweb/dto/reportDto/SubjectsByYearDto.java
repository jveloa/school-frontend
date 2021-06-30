package cu.edu.cujae.pweb.dto.reportDto;

public class SubjectsByYearDto {
    private String course;
    private int yearNumber;
    private String nameSubject;
    private int hours;

    public SubjectsByYearDto() {
    }

    public SubjectsByYearDto(String course, int yearNumber, String nameSubject, int hours) {
        this.course = course;
        this.yearNumber = yearNumber;
        this.nameSubject = nameSubject;
        this.hours = hours;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
