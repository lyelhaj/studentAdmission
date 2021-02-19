package com.CGS.admission.studentAdmission.controller;


import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.entities.Teacher;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.service.CourseService;
import com.CGS.admission.studentAdmission.service.MarksService;
import com.CGS.admission.studentAdmission.service.StudentService;
import com.CGS.admission.studentAdmission.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private TeacherService teacherService;


    //@RequestMapping(value="/index", method=RequestMethod.GET)
    @GetMapping("/teacher")
    public String getTeachers(Model md, @RequestParam(name="page", defaultValue="0") int page,
                              @RequestParam(name="kw", defaultValue = "") String ln) {
        Page<Teacher> teachers=teacherService.getByLastName(ln, PageRequest.of(page, 5));
        md.addAttribute("listTeachers", teachers.getContent());
        md.addAttribute("pages", new int [teachers.getTotalPages()]);
        md.addAttribute("currentPage", page);
        md.addAttribute("kw", ln);

        return "teachers";

    }
    @GetMapping("/deleteTeacher")
    public String delete(long id, int page,String kw) {
        teacherService.deleteTeacher(id);

        return "redirect:/teacher?page="+page+"&kw="+kw;
    }

    @GetMapping("/updateteacher")
    public String update(Model md, @RequestParam(name="id") Long id) {
        Teacher teacher=teacherService.getTeacher(id);
        md.addAttribute("teacher",  teacher);

        return "tupdate";

    }

    @GetMapping("/tupdate")
    public String tupdate(Model md, @RequestParam(name="id") Long id) {
        Teacher teacher=teacherService.getTeacher(id);
        md.addAttribute("teacher",  teacher);

        return "tupdate";

    }

    @GetMapping("/addteacher")
    public String addTeacher(Model md) {
        Teacher teacher=new Teacher();
        md.addAttribute(teacher);

        return "addteacher";
    }

    @GetMapping("/viewTeacher")
    public String viewTeacher(Model model,@RequestParam Long id,@RequestParam(name="page", defaultValue="0") int page){
        Marks marks=new Marks();
        List<Course> courses=courseService.findCoursesByTeacher(id);
        List<Marks> marksList=new ArrayList<>();
        for (Course c:courses){
            marksList.addAll(marksService.getByCourseId(c.getCourseId()));
        }
        List<Student> students= studentService.getall();
        Teacher teacher=teacherService.getTeacher(id);
        model.addAttribute(teacher);
        model.addAttribute("courseList",courses);
        model.addAttribute("marksList",marksList);
        model.addAttribute("studentList",students);
        model.addAttribute(marks);
        return "viewteacher";
    }

    @PostMapping("/saveTeacher")
    public String save(@ModelAttribute("teacher") Teacher teacher, String kw /*, @RequestParam String email*/){
        teacherService.addTeacher(teacher);

        /*emailServiceImp.send(email,"Admission", "This is for testing");*/
        return "redirect:/teacher?sId="+kw;

    }

    @PostMapping("/tsave")
    public String saveGrading(@ModelAttribute Marks marks,@RequestParam Long id){

marksService.addMarks(marks);
        return "redirect:/viewTeacher?id="+id;
    }
}
