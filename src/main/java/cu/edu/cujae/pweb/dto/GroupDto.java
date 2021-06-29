package cu.edu.cujae.pweb.dto;

public class GroupDto {
    private int codGroup;
    private YearDto year;
    private int numberGroup;

    public GroupDto() {
        this.year = new YearDto();
    }

    public GroupDto(int codGroup, YearDto year, int numberGroup) {
        this.codGroup = codGroup;
        this.year = year;
        this.numberGroup = numberGroup;
    }

    public GroupDto(int codGroup) {
        this.codGroup = codGroup;
    }

    public int getCodGroup() {
        return codGroup;
    }

    public void setCodGroup(int codGroup) {
        this.codGroup = codGroup;
    }

    public YearDto getYear() {
        return year;
    }

    public void setYear(YearDto year) {
        this.year = year;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }
}
