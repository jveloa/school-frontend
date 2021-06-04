package cu.edu.cujae.pweb.service;
import cu.edu.cujae.pweb.dto.*;
import java.util.List;

public interface SignatureService{
	List<SignatureDto> getSignatures();
    void createSignature(SignatureDto signature);
    void updateSignature(SignatureDto signature);
    void deleteSignature(String id);
}