package cu.edu.cujae.pweb.dto;

public class RangeEvaluationDto {
    private int codEvaluation;
    private String evaluation;

    public RangeEvaluationDto() {
    }

    public RangeEvaluationDto(int codEvaluation, String evaluation) {
        this.codEvaluation = codEvaluation;
        this.evaluation = evaluation;
    }

    public RangeEvaluationDto(int codEvaluation) {
        this.codEvaluation = codEvaluation;
    }

    public int getCodEvaluation() {
        return codEvaluation;
    }

    public void setCodEvaluation(int codEvaluation) {
        this.codEvaluation = codEvaluation;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
