package cu.edu.cujae.pweb.dto.reportDto;

public class StudentsByGroupDto {
    private String course;
    private int yearNumber;
    private String name;
    private String lastName;
    private int numberGroup;
    private int codStudent;

    public StudentsByGroupDto(String course, int yearNumber, String name, String lastName, int numberGroup, int codStudent) {
        this.course = course;
        this.yearNumber = yearNumber;
        this.name = name;
        this.lastName = lastName;
        this.numberGroup = numberGroup;
        this.codStudent = codStudent;
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

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public int getCodStudent() {
        return codStudent;
    }

    public void setCodStudent(int codStudent) {
        this.codStudent = codStudent;
    }
}
