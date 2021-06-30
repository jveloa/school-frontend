package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CourseDto;

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
public class CourseServiceImpl implements CourseService{

    @Autowired
    private RestService restService;

    @Override
    public List<CourseDto> getCourses() {
        List<CourseDto> courseList = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<CourseDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/courses/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            courseList = apiRestMapper.mapList(response, CourseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseList;

    }
}
