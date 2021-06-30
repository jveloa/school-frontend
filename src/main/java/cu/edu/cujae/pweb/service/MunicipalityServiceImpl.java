package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GroupDto;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalityServiceImpl implements MunicipalityService{
    @Autowired
    private RestService restService;
    @Override
    public List<MunicipalityDto> getMunicipalityList() {
        List<MunicipalityDto> municipalityList = new ArrayList<MunicipalityDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<MunicipalityDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/municipality", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            municipalityList = apiRestMapper.mapList(response, MunicipalityDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return municipalityList;
    }



    @Override
    public void createGroup(MunicipalityDto municipality){
        try{
            restService.POST("/api/v1/municipality",municipality,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGroup(int codmunicipality) {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/municipality/{codMunicipality}");
            String uri = template.expand(codmunicipality).toString();
            restService.DELETE(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
