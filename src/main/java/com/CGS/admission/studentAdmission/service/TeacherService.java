package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.entities.Teacher;
import com.CGS.admission.studentAdmission.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public Teacher getTeacher(Long id){
        return   teacherRepository.findById(id).get();
    }

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(Long id, Teacher teacher){
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }
    public Page<Teacher> getByLastName(String lastName, Pageable pageable){
        return teacherRepository.findByLastNameContains(lastName,pageable);
    }
}
