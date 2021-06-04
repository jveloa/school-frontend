package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService  {

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<UserDto>();
        users.add(new UserDto(1L,"jvelo","jvelo","Usuario"));
        users.add(new UserDto(2L,"nestor","nestor","Administrador"));
        users.add(new UserDto(3L,"giovanni","giovanni","Administrador"));
        users.add(new UserDto(4L,"abel","abel","Administrador"));
        return users;
    }
}
