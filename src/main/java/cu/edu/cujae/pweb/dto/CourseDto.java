package cu.edu.cujae.pweb.dto;

public class CourseDto {
    private int codCourse;
    private String course;

    public CourseDto() {
    }

    public CourseDto(int codCourse, String course) {
        this.codCourse = codCourse;
        this.course = course;
    }

    public CourseDto(int codCourse) {
        this.codCourse = codCourse;
    }

    public int getCodCourse() {
        return codCourse;
    }

    public void setCodCourse(int codCourse) {
        this.codCourse = codCourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

