package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CourseDto;
import cu.edu.cujae.pweb.dto.GroupDto;
import cu.edu.cujae.pweb.dto.YearDto;
import cu.edu.cujae.pweb.service.GroupService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageGroupBean {
    private GroupDto selectedGroup;
    private List<GroupDto> groups;
    private List<Integer> yearNumbers;


    @Autowired
    private GroupService groupService;



    public ManageGroupBean() {
    }


    public void openNew() {
        this.selectedGroup = new GroupDto();
    }


    public void saveGroup() throws SQLException {
        int numYear = selectedGroup.getYear().getYearNumber();
        List<GroupDto> groupsList = groupService.getGroupsLastCourse();
        int higherGroup = 0;
        int codYear = 0;

        for (GroupDto groupDto : groupsList) {
            int year = groupDto.getYear().getYearNumber();
            if (year == numYear) {
                if (groupDto.getNumberGroup() > higherGroup) {
                    higherGroup = groupDto.getNumberGroup();
                    codYear = groupDto.getYear().getCodYear();
                }
            }
        }

        GroupDto group = new GroupDto(0, new YearDto(codYear, 0, new CourseDto()), higherGroup + 1);
        groupService.createGroup(group);
        JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_added");

        //load datatable again with new values
        groups = groupService.getGroupList();
        PrimeFaces.current().executeScript("PF('manageGroupDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-group");
    }

    public void deleteGroup() throws SQLException {
        try {

            if(!groupService.isAssignmentsGroup(this.selectedGroup.getCodGroup())){
                groupService.deleteGroup(this.selectedGroup.getCodGroup());
                this.selectedGroup = null;
                groups = groupService.getGroupsLastCourse();

                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_deleted");
                PrimeFaces.current().ajax().update("form:dt-group");
            }else{
                JsfUtils.addMessageFromBundle(null,FacesMessage.SEVERITY_WARN,"message_group_is_assignments");
            }

        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
            e.printStackTrace();
        }

    }



    public GroupDto getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(GroupDto selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<GroupDto> getGroups() throws SQLException {
        return groupService.getGroupsLastCourse();
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<Integer> getYearNumbers() throws SQLException {
        List<Integer> intList = new ArrayList<>();
        for (GroupDto group: groupService.getGroupsLastCourse()) {
            if(!intList.contains(group.getYear().getYearNumber())){
                intList.add(group.getYear().getYearNumber());
            }
        }
        return intList;
    }

    public void setYearNumbers(List<Integer> yearNumbers) {
        this.yearNumbers = yearNumbers;
    }


}
