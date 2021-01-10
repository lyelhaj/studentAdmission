package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Student;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)

public class StudentRepositoryTest {
    @Mock
    Student student;

    @InjectMocks
    StudentRepository studentRepository;
    public void findAllTest(){
        Student student1=new Student();
        Student student2=new Student();
        Student student3=new Student();


        List<Student> students=new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Assert.assertEquals(3,studentRepository.findAll().size());
    }

}