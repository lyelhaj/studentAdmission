package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Course getCourse(Long id){
        return courseRepository.findById(id).get();
    }
     public List<Course> getAll(){
        return courseRepository.findAll();
     }

     public Course addCourse(Course course){
        return courseRepository.save(course);
     }

     public void deleteCourse(Long id){
        courseRepository.deleteById(id);
     }

     public Course updateCourse(Long id, Course course){
        course.setCourseId(id);
       return courseRepository.save(course);
     }

     public Page<Course> getByName(String name, Pageable pageable){
        return courseRepository.findByCourseNameContains(name,pageable);
     }

     public List<Course> findCoursesByTeacher(Long id){
        return courseRepository.findByTeacherId(id);
     }
}
