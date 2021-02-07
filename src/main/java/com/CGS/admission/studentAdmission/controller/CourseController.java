package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.*;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.service.CourseService;
import com.CGS.admission.studentAdmission.service.TeacherService;
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
public class CourseController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;

	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/course")
	public String course(Model md,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="keyWord", defaultValue="") String kw) {
		Page<Course> courses=courseService.getByName(kw,PageRequest.of(page, 10));
		md.addAttribute("listCourses", courses.getContent());
		md.addAttribute("pages", new int [courses.getTotalPages()]);
		md.addAttribute("currentPage", page);
		md.addAttribute("keyWord", kw);
		
		return "courses";
		
	}

	@GetMapping("/addcourse")
	public String addCourse(Model md) {
		Course course=new Course();
		List<Teacher> teachers=teacherService.getAll();
		md.addAttribute(course);
		md.addAttribute("teacherList",teachers);

		return "addCourse";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/deleteCourse")
	public String delete(long id, int page, String keyWord) {
	courseService.deleteCourse(id);
		
		return "redirect:/course?page="+page+"&keyWord="+keyWord;
	}

	@GetMapping("/updateCourse")
	public String update(Model md, @RequestParam(name="id") Long id) {
		Course cs=courseService.getCourse(id);
		md.addAttribute("course",  cs);

		return "cupdate";
		//return "redirect:/index?page="+page+"&keyWord="+keyWord;
	}

	@PostMapping("/saveCourse")
	public String save(@ModelAttribute("course") Course course, String kw,@RequestParam Long tId){
		Teacher teacher=teacherService.getTeacher(tId);
		course.setTeacher(teacher);
		courseService.addCourse(course);
		return "redirect:/course?kw="+kw;

	}

	@GetMapping("/viewCourse")
	public String viewCourse(Model model,@RequestParam Long id,@RequestParam(name="page", defaultValue="0") int page){
		Course course=courseService.getCourse(id);
		model.addAttribute(course);
		return "viewcourse";
	}

}
