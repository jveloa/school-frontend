package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;

public interface AuthService {

    UserAuthenticatedDto login(String username, String password);

}