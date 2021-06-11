package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.EvaluationDto;
import cu.edu.cujae.pweb.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageNotaBean {

    private EvaluationDto notaDto;
    private EvaluationDto selectedNota;
    private List<EvaluationDto> notas;
    private List<String> notasValores;

    public ManageNotaBean(){
    }

    @Autowired
    private EvaluationService evaluationService;

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
        this.selectedNota = new EvaluationDto();
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

    public EvaluationDto getNotaDto() {
        return notaDto;
    }

    public void setNotaDto(EvaluationDto notaDto) {
        this.notaDto = notaDto;
    }

    public List<String> getNotasValores() {
        return notasValores;
    }

    public void setNotasValores(List<String> notasValores) {
        this.notasValores = notasValores;
    }

    public EvaluationDto getSelectedNota() {
        return selectedNota;
    }

    public void setSelectedNota(EvaluationDto selectedNota) {
        this.selectedNota = selectedNota;
    }


    public List<EvaluationDto> getNotas() {
        return evaluationService.getNotas();
    }

    public void setNotas(List<EvaluationDto> notas) {
        this.notas = notas;
    }

    public EvaluationService getNotaService() {
        return evaluationService;
    }

    public void setNotaService(EvaluationService notaService) {
        this.evaluationService = notaService;
    }

}
