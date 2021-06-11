package cu.edu.cujae.pweb.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.UserService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@ViewScoped
public class ManageUserBean {
    private List<UserDto> users;
    private UserDto userDto;
    private UserDto selectedUser;

    @Autowired
    private UserService usersService;


    public ManageUserBean() {

    }

    public void openNew() {
        this.selectedUser = new UserDto();
     }

    public void openForEdit() {

    }

    public void saveUser() {
        if (this.selectedUser.getCodUser() == 0) {
            usersService.createUser(this.selectedUser);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_added");
        } else {
            usersService.updateUser(this.selectedUser);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_edited");
        }

        users = usersService.getUsers();
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-users");
    }

    public void deleteUser() {
        try{
            usersService.deleteUser(this.selectedUser.getCodUser());
            this.selectedUser = null;

            users = usersService.getUsers();

            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_deleted");
            PrimeFaces.current().ajax().update("form:dt-users");
        }catch (Exception e){
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
            e.printStackTrace();
        }

    }

    public List<UserDto> getUsers() {
        return usersService.getUsers();
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDto selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserService getUsersService() {
        return usersService;
    }

    public void setUsersService(UserService usersService) {
        this.usersService = usersService;
    }

}