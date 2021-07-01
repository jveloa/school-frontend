package cu.edu.cujae.pweb.dto;

public class YearDto {

    private int codYear;
    private int yearNumber;
    private CourseDto course;

    public YearDto() {
        course= new CourseDto();
    }

    public YearDto(int codYear, int yearNumber, CourseDto course) {
        this.codYear = codYear;
        this.yearNumber = yearNumber;
        this.course = course;
    }

    public YearDto(int codYear) {
        this.codYear = codYear;
    }

    public int getCodYear() {
        return codYear;
    }

    public void setCodYear(int codYear) {
        this.codYear = codYear;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }
}
