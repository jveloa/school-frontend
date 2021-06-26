package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.*;
import cu.edu.cujae.pweb.service.EstudiantesService;
import cu.edu.cujae.pweb.service.GroupService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.sql.SQLException;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageGroupBean {
    private GroupDto grupoDto;
    private GroupDto selectedGrupo;
    private List<GroupDto> grupos;

    @Autowired
    private GroupService groupService;



    public ManageGroupBean() {

    }




    public void openNew() {
        this.selectedGrupo = new GroupDto();
        this.selectedGrupo.setYear(new YearDto());
        this.selectedGrupo.getYear().setCourse(new CourseDto());
    }


    public void openForEdit() {

    }

    public void saveGroup() throws SQLException {
        if (this.selectedGrupo.getCodGroup() == 0) {
            this.selectedGrupo.setCodGroup((int) (Math.random()*100)+1);
            //register group
            groupService.createGroup(this.selectedGrupo);

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_added");
        }

        //load datatable again with new values
        grupos = groupService.getGroupList();
        PrimeFaces.current().executeScript("PF('manageGroupDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-group");
    }

    public void deleteGroup() {
        try {
            //delete groups
            groupService.deleteGroup(this.selectedGrupo.getCodGroup());
            this.selectedGrupo = null;

            //load datatable again with new values
            grupos = groupService.getGroupList();

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_deleted");
            PrimeFaces.current().ajax().update("form:dt-group");
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }


    public GroupDto getGrupoDto() {
        return grupoDto;
    }

    public void setGrupoDto(GroupDto grupoDto) {
        this.grupoDto = grupoDto;
    }

    public GroupDto getSelectedGrupo() {
        return selectedGrupo;
    }

    public void setSelectedGrupo(GroupDto selectedGrupo) {
        this.selectedGrupo = selectedGrupo;
    }

    public List<GroupDto> getGrupos() throws SQLException {
        grupos=groupService.getGroupList();
        return grupos;
    }

    public void setGrupos(List<GroupDto> grupos) {
        this.grupos = grupos;
    }
}
