package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Long id){
      return   studentRepository.findById(id).get();
    }

    public List<Student> getall(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deletStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student updatStudent(Long id, Student student){
        student.setStudentId(id);
        return studentRepository.save(student);
    }
public Page<Student> getByLastName(String lastName, Pageable pageable){
        return studentRepository.findByLastNameContains(lastName,pageable);
}

}

