package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.dto.reportDto.StudentForGroupDto;
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
public class ReportServiceImpl implements ReportService {

    @Autowired
    private RestService restService;

    @Override
    public List<StudentForGroupDto> getStudentForGroup() {
        List<StudentForGroupDto> studentForGrouplist = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<StudentForGroupDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/reports/",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
            studentForGrouplist = apiRestMapper.mapList(response,StudentForGroupDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return studentForGrouplist;
    }
}











