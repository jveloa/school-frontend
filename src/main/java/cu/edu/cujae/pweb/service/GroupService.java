package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.GroupDto;

import java.sql.SQLException;
import java.util.List;

public interface GroupService {
    List<GroupDto> getGroupList() throws SQLException;
    void createGroup(GroupDto group) throws SQLException;
    void deleteGroup(int codGroup) throws SQLException;
    List<GroupDto> getGroupsLastCourse() throws SQLException;
    boolean isAssignmentsGroup(int codGroup) throws SQLException;
}
