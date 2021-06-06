package cu.edu.cujae.pweb.dto;

public class LoginRequestDto {

    private String username;

    public LoginRequestDto(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    private String password;

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

}