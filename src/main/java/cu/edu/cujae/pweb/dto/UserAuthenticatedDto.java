package cu.edu.cujae.pweb.dto;

import java.util.List;

public class UserAuthenticatedDto {
    private Long id;
    private String username;

    private String password;

    private String rol;
    private String token;

    public UserAuthenticatedDto() {
        super();
    }

    public UserAuthenticatedDto(Long id, String username,  String password,
                                String rol, String token) {
        super();
        this.id = id;
        this.username = username;

        this.password = password;

        this.rol = rol;
        this.token = token;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
