package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.ReasonDropDto;

import java.util.List;

public interface ReasonDropService {
    List<ReasonDropDto> getReasonDropList();
    void createReasonDrop(ReasonDropDto reasonDrop);
    void deleteReasonDrop(int codReasonDrop);
}
