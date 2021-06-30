package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.MunicipalityDto;

import java.util.List;

public interface MunicipalityService {
    List<MunicipalityDto> getMunicipalityList();
    void createGroup(MunicipalityDto municipality);
    void deleteGroup(int codmunicipality);
}
