package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.RangeEvaluationDto;
import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RangeEvaluationService {

    List<RangeEvaluationDto> getRangeEvaluation();
    void createRangeEvaluation(RangeEvaluationDto rangeEvaluation);
    void updateRangeEvaluation(RangeEvaluationDto rangeEvaluation);
    void deleteRangeEvaluation(int codRangeEvaluation);

}
