package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.DropStudentDto;
import cu.edu.cujae.pweb.dto.StudentDto;
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
public class DropStudentServiceImpl implements DropStudentService {
    @Autowired
    private RestService restService;
    @Override
    public List<DropStudentDto> getBajas() {
        List<DropStudentDto>  bajas = new ArrayList<DropStudentDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<DropStudentDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/dropStudent/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            bajas =  apiRestMapper.mapList(response, DropStudentDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bajas;
    }



    @Override
    public void createDropStudent(DropStudentDto baja) {
        restService.POST("/api/v1/dropStudent/", baja, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void updateDropStudent(DropStudentDto baja)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/dropStudent/", params, baja, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void deleteDropStudent(int codStudent) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/dropStudent/{codStudent}");
        String uri = template.expand(codStudent).toString();
        restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }
}
