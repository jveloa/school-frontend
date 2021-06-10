package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService  {

    @Autowired
    private RestService restService;

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userList = new ArrayList<UserDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/users/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            userList = apiRestMapper.mapList(response, UserDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
