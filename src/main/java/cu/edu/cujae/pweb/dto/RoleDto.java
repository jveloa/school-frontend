package cu.edu.cujae.pweb.dto;

public class RoleDto {
    private int codRole;
    private String nameRole;

    public RoleDto() {
    }

    public RoleDto(int codRole) {
        this.codRole = codRole;
    }

    public RoleDto(int codRole, String nameRole) {
        this.codRole = codRole;
        this.nameRole = nameRole;
    }

    public int getCodRole() {
        return codRole;
    }

    public void setCodRole(int codRole) {
        this.codRole = codRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
