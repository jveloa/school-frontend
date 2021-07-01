package cu.edu.cujae.pweb.dto;

public class UserAuthenticatedDto {
    private int codUser;
    private String username;
    private String password;
    private RoleDto role;
    private String token;

    public UserAuthenticatedDto() {
    }

    public UserAuthenticatedDto(int codUser, String username, String password, RoleDto role, String token) {
        this.codUser = codUser;
        this.username = username;
        this.password = password;
        this.role = role;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
