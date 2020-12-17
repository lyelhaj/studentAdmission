package com.CGS.admission.studentAdmission.controller;


//import java.util.List;

import com.CGS.admission.studentAdmission.entities.Gender;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/student")
	public String getStudents(Model md,@RequestParam(name="page", defaultValue="0") int page,
						@RequestParam(name="kw", defaultValue = "") String ln) {
		Page<Student> students=studentRepository.findByLastNameContains(ln,PageRequest.of(page, 10));
		md.addAttribute("listStudents", students.getContent());
		md.addAttribute("pages", new int [students.getTotalPages()]);
		md.addAttribute("currentPage", page);
		md.addAttribute("kw", ln);

		return "students";

	}
	@GetMapping("/deleteStudent")
	public String delete(long id, int page,String kw) {
		studentRepository.deleteById(id);

		return "redirect:/student?page="+page+"&kw="+kw;
	}

	@GetMapping("/update")
	public String update(Model md, @RequestParam(name="id") Long id) {
		Student st=studentRepository.findById(id).get();
md.addAttribute("student",  st);

return "supdate";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/addstudent")
	public String addStudent(Model md) {
Student student=new Student();
student.setType(Gender.MALE);
md.addAttribute(student);

		return "addStudent";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@PostMapping("/save")
public String save(@ModelAttribute("student") Student student, String kw){
		studentRepository.save(student);
		return "redirect:/student?sId="+kw;

	}

}