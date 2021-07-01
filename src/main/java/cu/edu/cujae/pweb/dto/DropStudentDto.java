package cu.edu.cujae.pweb.dto;


//Baja
public class DropStudentDto {
    private ReasonDropDto reasonDrop;
    private StudentDto student;

    public DropStudentDto() {
    }

    public DropStudentDto(ReasonDropDto reasonDrop, StudentDto student) {
        this.reasonDrop = reasonDrop;
        this.student = student;
    }


    public ReasonDropDto getReasonDrop() {
        return reasonDrop;
    }

    public void setReasonDrop(ReasonDropDto reasonDrop) {
        this.reasonDrop = reasonDrop;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
