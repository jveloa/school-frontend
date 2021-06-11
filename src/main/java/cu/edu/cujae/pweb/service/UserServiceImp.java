package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

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

    @Override
    public void createUser(UserDto user){
        try{
            restService.POST("/api/v1/users/",user,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int codUser) {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/users/{codUser}");
            String uri = template.expand(codUser).toString();
            restService.DELETE(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UserDto user) {
        try{
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            restService.PUT("api/v1/users/",params,user,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
