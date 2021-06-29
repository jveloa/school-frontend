package cu.edu.cujae.pweb.dto.reportDto;

public class StudentLadderDto {
    private int rank;
    private String name;
    private String lastName;
    private int numberGroup;
    private  double avg;

    public StudentLadderDto(){

    }
    public StudentLadderDto(int rank, String name, String lastName, int numberGroup, double avg) {
        this.rank = rank;
        this.name = name;
        this.lastName = lastName;
        this.numberGroup = numberGroup;
        this.avg = avg;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
