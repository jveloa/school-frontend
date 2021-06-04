package cu.edu.cujae.pweb.dto;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class SignatureDto{
	private String id;
	private String name;
	private int hours;
	private int year;
	private String curse;
	
	public SignatureDto() {
		super();
		}
	public SignatureDto(String id, String name, int hours, int year, String curse) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.year = year;
		this.curse = curse;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNamae(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCurse() {
		return curse;
	}
	public void setCurse(String curse) {
		this.curse = curse;
	}
	
}