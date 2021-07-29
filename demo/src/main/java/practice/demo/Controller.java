package practice.demo;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
//@RequestMapping(path = "/students")
public class Controller {
	
	private StudentDAO studentDao;
	
//	@GetMapping("/hello")
//	public String helloAPI() {
//		return "This is my first API";
//	}
	
	@GetMapping(path="/getstudents")
    public String getStudents() 
    {
        return "all students here";
    }
	
//	@GetMapping(path="/", produces = "application/json")
//    public Students getStudents() 
//    {
//        return studentDao.getStudents();
//    }
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Student student) 
    {
        Integer id = studentDao.getStudents().getStudentList().size() + 1;
        student.setId(id);
         
        studentDao.addStudent(student);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(student.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
	
	
	
	
	
	

}
