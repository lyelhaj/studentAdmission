package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.entities.Gender;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/course")
	public String course(Model md,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="keyWord", defaultValue="") String kw) {
		Page<Course> courses=courseRepository.findByCourseNameContains(kw,PageRequest.of(page, 10));
		md.addAttribute("listCourses", courses.getContent());
		md.addAttribute("pages", new int [courses.getTotalPages()]);
		md.addAttribute("currentPage", page);
		md.addAttribute("keyWord", kw);
		
		return "courses";
		
	}

	@GetMapping("/addcourse")
	public String addCourse(Model md) {
		Course course=new Course();
		md.addAttribute(course);

		return "addCourse";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/deleteCourse")
	public String delete(long id, int page, String keyWord) {
	courseRepository.deleteById(id);
		
		return "redirect:/course?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/updateCourse")
	public String update(Model md, @RequestParam(name="id") Long id) {
		Course cs=courseRepository.findById(id).get();
		md.addAttribute("course",  cs);

		return "cupdate";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@PostMapping("/saveCourse")
	public String save(@ModelAttribute("course") Course course, String kw){
		courseRepository.save(course);
		return "redirect:/course?kw="+kw;

	}


}
