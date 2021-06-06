package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.SignatureDto;
import cu.edu.cujae.pweb.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
public class ManageSignatureBean {
    private List<SignatureDto> signatures;
    private SignatureDto selectedsignature;
    private SignatureDto signatureDto;

    @Autowired
    private SignatureService signatureService;

    public ManageSignatureBean() {
    }

   /* @PostConstruct
    public void init() {
        signatures = signatures == null ? signatureService.getSignatures() : signatures;
    }*/

    public List<SignatureDto> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<SignatureDto> signatures) {
        this.signatures = signatures;
    }

    public void openNew() {
        selectedsignature = new SignatureDto();
    }

    public void openForEdit() {

    }

    public SignatureDto getSelectedsignature() {
        return selectedsignature;
    }


    public void setSelectedsignature(SignatureDto selectedsignature) {
        this.selectedsignature = selectedsignature;
    }

    public SignatureDto getSignatureDto() {
        return signatureDto;
    }

    public void setSignatureDto(SignatureDto signatureDto) {
        this.signatureDto = signatureDto;
    }

    public SignatureService getSignatureService() {
        return signatureService;
    }

    public void setSignatureService(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    public void saveSignature() {

    }
}