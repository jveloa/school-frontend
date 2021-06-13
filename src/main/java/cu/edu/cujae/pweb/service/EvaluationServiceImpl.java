package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.EvaluationDto;
import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.dto.UserDto;
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
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private RestService restService;

    @Override
    public List<EvaluationDto> getNotas(StudentDto student) {
        int codStudent = student.getCodStudent();
        List<EvaluationDto> evaluationList = new ArrayList<EvaluationDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<EvaluationDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/evaluations/"+String.valueOf(codStudent), params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            evaluationList = apiRestMapper.mapList(response, EvaluationDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return evaluationList;
    }

    @Override
    public List<List<String>> getNotasTest() {
        return null;
    }

    @Override
    public void createNota(EvaluationDto nota) {
        restService.POST("/api/v1/evaluations/", nota, String.class, CurrentUserUtils.getTokenBearer()).getBody();

    }

    @Override
    public void updateNota(EvaluationDto nota) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/evaluations/", params, nota, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }


    @Override
    public void deleteNota(int  codigo_asignatura, int codigo_anno, int codigo_estudiante) {
        // TODO Auto-generated method stub

    }
}
