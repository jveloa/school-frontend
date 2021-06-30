package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.CourseDto;

import cu.edu.cujae.pweb.dto.reportDto.StudentLadderDto;

import cu.edu.cujae.pweb.service.CourseService;
import cu.edu.cujae.pweb.service.ReportService;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageStudentLadderBean {
    private String selectedCourse;
    private int yearNumber;
    private List<StudentLadderDto> studentLadderDtoList;
    private List<CourseDto> courses;
    private String hide;


    @Autowired
    private ReportService reportService;

    @Autowired
    private CourseService courseService;

    public List<CourseDto> getCourses() {
        courses = courseService.getCourses();
        return courses;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public ManageStudentLadderBean() {

    }
    public void updateList(){
        if(selectedCourse == "" || yearNumber == 0)
            studentLadderDtoList = new ArrayList<>();
        else
            studentLadderDtoList = reportService.getStudentLadderDtoList(selectedCourse, yearNumber);
    }
    public List<StudentLadderDto> getStudentLadderDtoList(){
        return studentLadderDtoList;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setStudentLadderDtoList(List<StudentLadderDto> studentLadderDtoList) {
        this.studentLadderDtoList = studentLadderDtoList;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }
}
