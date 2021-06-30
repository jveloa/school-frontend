package cu.edu.cujae.pweb.dto;

public class RecordDto {
    private GroupDto group;
    private StudentDto student;

    public RecordDto() {
    }

    public RecordDto(GroupDto group, StudentDto student) {
        this.group = group;
        this.student = student;
    }

    public GroupDto getGroup() {
        return group;
    }

    public void setGroup(GroupDto group) {
        this.group = group;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
