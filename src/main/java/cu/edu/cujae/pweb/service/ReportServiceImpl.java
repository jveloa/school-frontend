package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.reportDto.EvalByGroupDto;
import cu.edu.cujae.pweb.dto.reportDto.StudentLadderDto;
import cu.edu.cujae.pweb.dto.reportDto.StudentsByGroupDto;
import cu.edu.cujae.pweb.dto.reportDto.SubjectsByYearDto;
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
public class ReportServiceImpl implements ReportService {

    @Autowired
    private RestService restService;

    @Override
    public List<StudentsByGroupDto> getStudentByGroup() {
        List<StudentsByGroupDto> studentForGrouplist = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<StudentsByGroupDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/reports/studentsByGroup",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
            studentForGrouplist = apiRestMapper.mapList(response, StudentsByGroupDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return studentForGrouplist;
    }

    @Override
    public List<SubjectsByYearDto> getSubjectsByYear() {
        List<SubjectsByYearDto> subjectsByYearList = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<SubjectsByYearDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/reports/subjectsByYear",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
            subjectsByYearList = apiRestMapper.mapList(response, SubjectsByYearDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return subjectsByYearList;
    }

    @Override
    public List<StudentLadderDto> getStudentLadderDtoList(String course, int year) {
        List<StudentLadderDto> studentLadderDtoList = new ArrayList<StudentLadderDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/reports//studentLadder/{curso}/{anno}");
            String uri = template.expand(course, year).toString();
            ApiRestMapper<StudentLadderDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET(uri,params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
            studentLadderDtoList = apiRestMapper.mapList(response, StudentLadderDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        /*if(course.equalsIgnoreCase("2017-2018")) {
            if (year == 1)
            studentLadderDtoList.add(new StudentLadderDto(1, "Abel", "Belda", 31, 4.56));
            if(year == 2)
            studentLadderDtoList.add(new StudentLadderDto(2, "Abael", "Be33lda", 31, 4.53));
            if(year ==3)
            studentLadderDtoList.add(new StudentLadderDto(3, "Abeaaaal", "Be1111lda", 31, 4.23));
        }
        else{
            if (year == 1)
                studentLadderDtoList.add(new StudentLadderDto(1, "tatata", "Belda", 31, 4.56));
            if(year == 2)
                studentLadderDtoList.add(new StudentLadderDto(2, "asd", "Be33lda", 31, 4.53));
            if(year ==3)
                studentLadderDtoList.add(new StudentLadderDto(3, "3ra", "Be1111lda", 31, 4.23));

        }*/
        return studentLadderDtoList;
    }

    @Override
    public List<EvalByGroupDto> getEvalByGroup() {
        List<EvalByGroupDto> evalByGroupDtoList = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<EvalByGroupDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/reports/evalByGroup",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
            evalByGroupDtoList = apiRestMapper.mapList(response, EvalByGroupDto.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return evalByGroupDtoList;
    }

}











