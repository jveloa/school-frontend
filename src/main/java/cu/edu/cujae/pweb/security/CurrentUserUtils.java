package cu.edu.cujae.pweb.security;

import org.springframework.security.core.context.SecurityContextHolder;


public class CurrentUserUtils {
	
	public CurrentUserUtils() {
		super();
	}

	private static final String ANONYMOUS_USER = "anonymousUser";
	
	public static String getUsername() {
		String username = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			username = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		}
		return username;
	}
	

	
	public static String getTokenBearer() {
		String token = null;
		if (isLogged()) {
			token = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getToken();
		}
		return token;
	}
	

	
	public static Long getUserId() {
		Long userId = null;
		if (isLogged()) {
			userId = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCodUser();
		}
		return userId;
	}
	
	public static boolean isLogged() {
		boolean logged = false;
		if ((SecurityContextHolder.getContext().getAuthentication() != null) && (!getUsername().equals(ANONYMOUS_USER))) {
			logged = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		}
		return logged;
	}
	
	public static String getPassword() {
		String password = null;
		if (isLogged()) {
			password = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		}
		return password;
	}
	
}
