package cu.edu.cujae.pweb.dto;


public class UserDto {
    private Long id;
	private String user;
	private String password;
	private String rol;
	
	public UserDto() {
		super();
	}

    public UserDto(Long id,String user, String password, String rol) {
	    this.id = id;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
