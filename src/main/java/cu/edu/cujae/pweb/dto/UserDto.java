package cu.edu.cujae.pweb.dto;


public class UserDto {
    private int codUser;
    private String username;
    private String password;
    private RoleDto role;

    public UserDto() {
    }


    public UserDto(int codUser, String username, String password, RoleDto role) {
        this.codUser = codUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }
}

