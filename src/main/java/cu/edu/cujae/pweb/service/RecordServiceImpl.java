package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.RecordDto;
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
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RestService restService;
    @Override
    public List<RecordDto> getEstudiantes() {
        List<RecordDto>  record = new ArrayList<RecordDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<RecordDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/record/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            record =  apiRestMapper.mapList(response, RecordDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return record;
    }



    @Override
    public void createRecord(RecordDto record) {
        restService.POST("/api/v1/record/", record, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void updateRecord(RecordDto record)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/record/", params, record, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }


}
