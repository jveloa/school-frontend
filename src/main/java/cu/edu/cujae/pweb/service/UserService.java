package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.UserDto;

import java.util.List;

public interface UserService {


    List<UserDto> getUsers();
    void createUser(UserDto user);
    void updateUser(UserDto user);
    void deleteUser(int codUser);

}
