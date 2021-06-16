package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.RangeEvaluationDto;
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
public class RangeEvaluationServiceImpl implements RangeEvaluationService {

    @Autowired
    private RestService restService;

    @Override
    public List<RangeEvaluationDto> getRangeEvaluation() {
        List<RangeEvaluationDto> rangeEvaluationList = new ArrayList<>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<RangeEvaluationDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/rangeEvaluations/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
            rangeEvaluationList = apiRestMapper.mapList(response, RangeEvaluationDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rangeEvaluationList;
    }

    @Override
    public void createRangeEvaluation(RangeEvaluationDto rangeEvaluation) {

    }

    @Override
    public void updateRangeEvaluation(RangeEvaluationDto rangeEvaluation) {

    }

    @Override
    public void deleteRangeEvaluation(int codRangeEvaluation) {

    }
}
