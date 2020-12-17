package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.Gender;
import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.entities.Semestre;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MarksController {
	@Autowired
	private MarksRepository marksRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/marks")
	public String marks(Model md,@RequestParam(name="page", defaultValue="0") int page,
						@RequestParam(name="kw", defaultValue="")  String kw) {

		Page<Marks> markses=marksRepository.findByStLastNameContains(kw,PageRequest.of(page, 10));
		md.addAttribute("listMarkses", markses.getContent());
		md.addAttribute("pages", new int [markses.getTotalPages()]);
		md.addAttribute("currentPage", page);
		md.addAttribute("keyWord", kw);
		
		return "markses";
		
	}
	@GetMapping("/deleteMarks")
	public String delete(long id, int page, String kw) {
		marksRepository.deleteById(id);
		
		return "redirect:/marks?page="+page+"&kw="+kw;
	}

	@GetMapping("/addmarks")
	public String addStudent(Model md) {
		Marks marks=new Marks();
		marks.setSeason(Semestre.JANUARY);
		md.addAttribute(marks);

		return "addMarks";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/updateMarks")
	public String update(Model md, @RequestParam(name="id") Long id) {
		Marks marks=marksRepository.findById(id).get();
		md.addAttribute("marks",  marks);

		return "mupdate";
	}

	@PostMapping("/saveMarks")
	public String save(@ModelAttribute("marks") Marks marks, String kw){
		marksRepository.save(marks);
		kw="";
		return "redirect:/marks?kw="+kw;

	}

}
