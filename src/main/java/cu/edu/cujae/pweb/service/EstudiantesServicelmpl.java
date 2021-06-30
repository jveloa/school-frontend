package cu.edu.cujae.pweb.service;




import cu.edu.cujae.pweb.dto.GroupDto;
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
import java.util.UUID;

import static java.util.UUID.*;
@Service
public class EstudiantesServicelmpl implements EstudiantesService{
    @Autowired
    private RestService restService;
    @Override
    public List<StudentDto> getEstudiantes() {
        List<StudentDto>  estudiantes = new ArrayList<StudentDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<StudentDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/students/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            estudiantes =  apiRestMapper.mapList(response, StudentDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }

    public StudentDto getEstudiantesById(String estudiantesId) {
        StudentDto estudiante = null;

        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<StudentDto> apiRestMapper = new ApiRestMapper<>();

            UriTemplate template = new UriTemplate("/api/v1/students/{studentsId}");
            String uri = template.expand(estudiantesId).toString();
            String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            estudiante = apiRestMapper.mapOne(response, StudentDto.class);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return estudiante;
    }

    @Override
    public void createEstudiantes(StudentDto estudiante) {
        restService.POST("/api/v1/students/", estudiante, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void updateEstudiantes(StudentDto estudiante)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/students/", params, estudiante, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void deleteEstudiantes(int codStudent) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/students/{codStudent}");
        String uri = template.expand(codStudent).toString();
        restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }
    @Override
    public GroupDto getGroupByStudent(int codEst) {

        GroupDto group = null;

        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<GroupDto> apiRestMapper = new ApiRestMapper<>();

            UriTemplate template = new UriTemplate("/api/v1/students/group/{codStudent}");
            String uri = template.expand(codEst).toString();
            String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            group = apiRestMapper.mapOne(response, GroupDto.class);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return group;
    }




}
