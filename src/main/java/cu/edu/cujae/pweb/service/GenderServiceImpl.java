package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GenderDto;
import cu.edu.cujae.pweb.dto.MunicipalityDto;
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
public class GenderServiceImpl implements GenderService{
    @Autowired
    private RestService restService;
    @Override
    public List<GenderDto> getGenderList() {
        List<GenderDto> genderList = new ArrayList<GenderDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<GenderDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/genders/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            genderList = apiRestMapper.mapList(response, GenderDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genderList;
    }



    @Override
    public void createGroup(GenderDto gender){
        try{
            restService.POST("/api/v1/genders/",gender,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGroup(int codGender) {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/genders/{codGender}");
            String uri = template.expand(codGender).toString();
            restService.DELETE(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
