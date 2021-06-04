package cu.edu.cujae.pweb.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.UserService;
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

    @PostConstruct
    public void init() {
        users = users == null ? usersService.getUsers() : users;

    }

    public void openNew() {

        this.selectedUser = new UserDto();
     }

    public void openForEdit() {

    }

    public void saveUser() {
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
    }

    public void deleteUser() {

    }

    public List<UserDto> getUsers() {
        return users;
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