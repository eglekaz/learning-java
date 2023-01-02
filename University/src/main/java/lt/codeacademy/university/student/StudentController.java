package lt.codeacademy.university.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/signup")
    public String showSignUpForm(Student student) {
        return "add-student";
	}
	
	@PostMapping("/addstudent")
    public String addStudent(
    		@Validated Student student, 
    		BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        studentRepository.save(student);
        return "redirect:/students/index";
    }
	
	
	@GetMapping("/all")
	public 
	@ResponseBody Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/index")
	public String showStudentsList(Model model) {
	    model.addAttribute("students", studentRepository.findAll());
	    return "index";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") int id, Student student, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        student.setId(id);
	        return "update-student";
	    }
	    studentRepository.save(student);
	    return "redirect:/students/index";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Student student = studentRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	    model.addAttribute("student", student);
	    return "update-student";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, Model model) {
	    Student student = studentRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	    studentRepository.delete(student);
	    return "redirect:/students/index";
	}
}
