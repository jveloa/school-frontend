package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GenderDto;
import cu.edu.cujae.pweb.dto.ReasonDropDto;
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
public class ReasonDropServiceImpl implements ReasonDropService {
    @Autowired
    private RestService restService;
    @Override
    public List<ReasonDropDto> getReasonDropList() {
        List<ReasonDropDto> reasonDropList = new ArrayList<ReasonDropDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<ReasonDropDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/reasonsDrop/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            reasonDropList = apiRestMapper.mapList(response, ReasonDropDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reasonDropList;
    }



    @Override
    public void createReasonDrop(ReasonDropDto reasonDrop){
        try{
            restService.POST("/api/v1/reasonsDrop/",reasonDrop,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteReasonDrop(int codReasonDrop) {
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/genders/{codReasonDrop}");
            String uri = template.expand(codReasonDrop).toString();
            restService.DELETE(uri,params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
