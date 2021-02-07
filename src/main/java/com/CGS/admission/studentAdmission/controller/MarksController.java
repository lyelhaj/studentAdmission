package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.*;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import com.CGS.admission.studentAdmission.service.CourseService;
import com.CGS.admission.studentAdmission.service.EmailServiceImpl;
import com.CGS.admission.studentAdmission.service.MarksService;
import com.CGS.admission.studentAdmission.service.StudentService;
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
	private MarksService marksService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@Autowired
	private EmailServiceImpl emailServiceImp;
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/marks")
	public String marks(Model md,@RequestParam(name="page", defaultValue="0") int page,
						@RequestParam(name="kw", defaultValue="")  String kw) {

		Page<Marks> markses=marksService.getByLastName(kw,PageRequest.of(page, 10));
		md.addAttribute("listMarkses", markses.getContent());
		md.addAttribute("pages", new int [markses.getTotalPages()]);
		md.addAttribute("currentPage", page);
		md.addAttribute("keyWord", kw);
		
		return "markses";
		
	}
	@GetMapping("/deleteMarks")
	public String delete(long id, int page, String kw) {
		marksService.deleteMarks(id);
		
		return "redirect:/marks?page="+page+"&kw="+kw;
	}

	@GetMapping("/addmarks")
	public String addStudent(Model md) {
		List<Course> courses=courseService.getAll();
		List<Student> students=studentService.getall();
		Marks marks=new Marks();
		marks.setSeason(Semestre.JANUARY);
		md.addAttribute(marks);
		md.addAttribute("courseList",courses);
		md.addAttribute("studentList",students);

		return "addMarks";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/updateMarks")
	public String update(Model md, @RequestParam(name="id") Long id) {
		Marks marks=marksService.getMarks(id);
		md.addAttribute("marks",  marks);

		return "mupdate";
	}

	@GetMapping("/viewMarks")
	public String viewStudent(Model model,@RequestParam Long id,@RequestParam(name="page", defaultValue="0") int page){
		Marks marks=marksService.getMarks(id);
		model.addAttribute("marks",marks);
		return "viewmarks";
	}

	@PostMapping("/saveMarks")
	public String save(@ModelAttribute("marks") Marks marks,  String kw, @RequestParam Long cId,@RequestParam Long sId){
		Student st=studentService.getStudent(sId);
		Course cs=courseService.getCourse(cId);
		marks.setSt(st);
		marks.setCs(cs);
		marksService.addMarks(marks);
		kw="";
		Student student=studentService.getStudent(marks.getSt().getStudentId());
		Course course=courseService.getCourse(marks.getCs().getCourseId());

		emailServiceImp.send(student.getEmail(),"Marks",
				"Dear "+student.getLastName()+",\n Your final result for "+course.getCourseName()+" Marks "+marks.avarege()+" Grade : "+marks.grade()
		+" \n Cardially.");
		return "redirect:/marks?kw="+kw;

	}

}
