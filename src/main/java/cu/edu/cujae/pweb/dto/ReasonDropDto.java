package cu.edu.cujae.pweb.dto;

public class ReasonDropDto {
    private int codReason;
    private String reason;

    public ReasonDropDto() {
    }

    public ReasonDropDto(int codReason, String reason) {
        this.codReason = codReason;
        this.reason = reason;
    }

    public int getCodReason() {
        return codReason;
    }

    public void setCodReason(int codReason) {
        this.codReason = codReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
