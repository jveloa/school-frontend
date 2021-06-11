package cu.edu.cujae.pweb.dto;

public class EvaluationDto {
    private SubjectDto subject;
    private StudentDto student;
    private YearDto year;
    private RangeEvaluationDto rangeEvaluation;

    public EvaluationDto() {
    }

    public EvaluationDto(SubjectDto subject, StudentDto student, YearDto year, RangeEvaluationDto rangeEvaluation) {
        this.subject = subject;
        this.student = student;
        this.year = year;
        this.rangeEvaluation = rangeEvaluation;
    }

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public YearDto getYear() {
        return year;
    }

    public void setYear(YearDto year) {
        this.year = year;
    }

    public RangeEvaluationDto getRangeEvaluation() {
        return rangeEvaluation;
    }

    public void setRangeEvaluation(RangeEvaluationDto rangeEvaluation) {
        this.rangeEvaluation = rangeEvaluation;
    }
}
