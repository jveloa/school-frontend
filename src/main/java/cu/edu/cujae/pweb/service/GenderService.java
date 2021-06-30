package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GenderDto;

import java.util.List;

public interface GenderService {
    List<GenderDto> getGenderList();
    void createGroup(GenderDto gender);
    void deleteGroup(int codGender);
}
