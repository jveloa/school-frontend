package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.EvaluationDto;
import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.dto.SubjectDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.*;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private RestService restService;

	@Override
	public List<SubjectDto> getSubjects(){
		List<SubjectDto> subjectList = new ArrayList<SubjectDto>();
		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			ApiRestMapper<SubjectDto> apiRestMapper = new ApiRestMapper<>();
			String response = (String)restService.GET("/api/v1/subjects/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
			subjectList = apiRestMapper.mapList(response, SubjectDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	@Override
    public void createSubject(SubjectDto Subject) {
    	
    }
	@Override
    public void updateSubject(SubjectDto Subject) {
    	
    }
	@Override
    public void deleteSubject(String id) {
    	
    }

	@Override
	public List<SubjectDto> getSubjectsByStudent(int codStudent) {
		List<SubjectDto> subjects = new ArrayList<SubjectDto>();
		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			ApiRestMapper<SubjectDto> apiRestMapper = new ApiRestMapper<>();
			String response = (String)restService.GET("/api/v1/subjects/student/"+String.valueOf(codStudent), params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
			subjects = apiRestMapper.mapList(response, SubjectDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return subjects;
	}

	@Override
	public List<SubjectDto> getSubjectsEvaluatedByStudent(int codStudent) {
		List<SubjectDto> subjects = new ArrayList<SubjectDto>();
		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			ApiRestMapper<SubjectDto> apiRestMapper = new ApiRestMapper<>();
			String response = (String)restService.GET("/api/v1/subjects/evaluated/student/"+String.valueOf(codStudent), params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
			subjects = apiRestMapper.mapList(response, SubjectDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return subjects;
	}

	@Override
	public SubjectDto getSubjectById(int codSubject) {
		SubjectDto subject = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			ApiRestMapper<SubjectDto> apiRestMapper = new ApiRestMapper<>();

			UriTemplate template = new UriTemplate("/api/v1/subjects/{codSubject}");
			String uri = template.expand(codSubject).toString();
			String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
			subject= apiRestMapper.mapOne(response, SubjectDto.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return subject;
	}


}