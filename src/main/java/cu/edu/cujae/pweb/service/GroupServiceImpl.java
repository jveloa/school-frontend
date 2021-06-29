package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GroupDto;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl  implements GroupService{
    @Autowired
    private RestService restService;
    @Override
    public List<GroupDto> getGroupList() {
        List<GroupDto> groupList = new ArrayList<GroupDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<GroupDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/groups/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            groupList = apiRestMapper.mapList(response, GroupDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public List<GroupDto> getGroupsLastCourse() throws SQLException {
        List<GroupDto> groupList = new ArrayList<GroupDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<GroupDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/groups/groupsLastCourse", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            groupList = apiRestMapper.mapList(response, GroupDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public void createGroup(GroupDto group){
        try{
            restService.POST("/api/v1/groups/",group,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGroup(int codGroup) {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/groups/{codGroup}");
            String uri = template.expand(codGroup).toString();
            restService.DELETE(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAssignmentsGroup(int codGroup) throws SQLException {
        boolean is = false;
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<Boolean> apiRestMapper = new ApiRestMapper<>();
            UriTemplate template = new UriTemplate("/api/v1/groups/isAssignmentsGroup/{codGroup}");
            String uri = template.expand(codGroup).toString();
            String response = (String) restService.GET(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
            is = apiRestMapper.mapOne(response, Boolean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return is;
    }
}
