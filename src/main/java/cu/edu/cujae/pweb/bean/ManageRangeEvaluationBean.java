package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.RangeEvaluationDto;
import cu.edu.cujae.pweb.service.RangeEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageRangeEvaluationBean {

    private List<RangeEvaluationDto> evaluations;


    @Autowired
    private RangeEvaluationService rangeEvaluationService;

    /*@PostConstruct
    public void init(){
        evaluations = rangeEvaluationService.getRangeEvaluation();
    }*/
    public ManageRangeEvaluationBean() {
    }

    public List<RangeEvaluationDto> getEvaluations() {
        evaluations = rangeEvaluationService.getRangeEvaluation();
        return evaluations;
    }

    public void setEvaluations(List<RangeEvaluationDto> evaluations) {
        this.evaluations = evaluations;
    }
}
