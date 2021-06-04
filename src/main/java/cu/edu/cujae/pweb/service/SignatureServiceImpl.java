package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.SignatureDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.*;

@Service
public class SignatureServiceImpl implements SignatureService{ 
	
	public List<SignatureDto> getSignatures() {
		List<SignatureDto> signatures = new ArrayList<SignatureDto>();
		signatures.add(new SignatureDto(randomUUID().toString().replaceAll("-", "").substring(0, 9), "M3", 38, 2, "2018-2019"));
		signatures.add(new SignatureDto(randomUUID().toString().replaceAll("-", "").substring(0, 9), "M1", 56, 1, "2019-2020"));
		signatures.add(new SignatureDto(randomUUID().toString().replaceAll("-", "").substring(0, 9), "Redes", 83, 4, "2019-2020"));
		signatures.add(new SignatureDto(randomUUID().toString().replaceAll("-", "").substring(0, 9), "RA", 23, 2, "2019-2020"));
		signatures.add(new SignatureDto(randomUUID().toString().replaceAll("-", "").substring(0, 9), "MD", 1, 1, "2019-2020"));
		return signatures;
	}
	@Override
    public void createSignature(SignatureDto signature) {
    	
    }
	@Override
    public void updateSignature(SignatureDto signature) {
    	
    }
	@Override
    public void deleteSignature(String id) {
    	
    }

}