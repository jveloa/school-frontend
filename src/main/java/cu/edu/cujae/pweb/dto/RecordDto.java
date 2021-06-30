package cu.edu.cujae.pweb.dto;

public class RecordDto {
    private  StudentDto studentDto;
    private GroupDto groupDto;
    public RecordDto() {super(); }
    public RecordDto(GroupDto groupDto,StudentDto studentDto ) {
        this.studentDto = studentDto;
        this.groupDto = groupDto;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public GroupDto getGroupDto() {
        return groupDto;
    }

    public void setGroupDto(GroupDto groupDto) {
        this.groupDto = groupDto;
    }
}
