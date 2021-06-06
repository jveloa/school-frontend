package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.NotaDto;
import cu.edu.cujae.pweb.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageNotaBean {

    private NotaDto notaDto;
    private NotaDto selectedNota;
    private List<NotaDto> notas;
    private List<List<String>> notasPrueba;
    private List<String> notasValores;

    public ManageNotaBean(){
    }

    @Autowired
    private NotaService notaService;

    /*@PostConstruct
    public void init() {
        notasPrueba =notasPrueba == null ? notaService.getNotasTest() : notasPrueba;
        this.notasValores = new ArrayList<String>(){{
            add("2");
            add("3");
            add("4");
            add("5");
        }};

    }*/

    public void openNew() {
        this.selectedNota = new NotaDto();
    }

    public void openForEdit() {
        //
    }

    public void saveNota() {
        /*if (this.selectedNotaPrueba == null) {

            this.notasPrueba.add(this.selectedNotaPrueba);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_edited");
        }

        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
*/
    }

    public void deleteUser() {
        /*try {
            this.notasPrueba.remove(this.selectedNotaPrueba);
            this.selectedNotaPrueba = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_removed");
            PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
*/
    }

    public NotaDto getNotaDto() {
        return notaDto;
    }

    public void setNotaDto(NotaDto notaDto) {
        this.notaDto = notaDto;
    }

    public List<String> getNotasValores() {
        return notasValores;
    }

    public void setNotasValores(List<String> notasValores) {
        this.notasValores = notasValores;
    }

    public NotaDto getSelectedNota() {
        return selectedNota;
    }

    public void setSelectedNota(NotaDto selectedNota) {
        this.selectedNota = selectedNota;
    }


    public List<NotaDto> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDto> notas) {
        this.notas = notas;
    }

    public List<List<String>> getNotasPrueba() {
        return notasPrueba;
    }

    public void setNotasPrueba(List<List<String>> notasPrueba) {
        this.notasPrueba = notasPrueba;
    }

    public NotaService getNotaService() {
        return notaService;
    }

    public void setNotaService(NotaService notaService) {
        this.notaService = notaService;
    }

}
