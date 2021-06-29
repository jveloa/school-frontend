package cu.edu.cujae.pweb.dto.reportDto;

public class EvalByGroupDto {
    private String course;
    private int yearNumber;
    private int groupNumber;
    private String subjectName;
    private String studentName;
    private String studentLastName;
    private String evaluacion;

    public EvalByGroupDto(){

    }


    public EvalByGroupDto(String course, int yearNumber, int groupNumber, String subjectName, String studentName, String studentLastName, String evaluacion) {
        this.course = course;
        this.yearNumber = yearNumber;
        this.groupNumber = groupNumber;
        this.subjectName = subjectName;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.evaluacion = evaluacion;
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

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }
}
