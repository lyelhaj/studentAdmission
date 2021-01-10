package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    private static final Long id=2l;
    @Mock
    private Student student;
    @Mock
    private Student studentUpdate;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    public StudentServiceTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of insert method, of class StudentServiceImpl.
     */
    @Test
    public void addStudentTest() {
          studentService.addStudent(student);
           verify(studentRepository).save(student);
        System.out.println("Test addStudent");
    }

    /**
     * Test of update method, of class StudentServiceImpl.
     */
    @Test
    public void testUpdateStudent() {

        studentService.updatStudent(id,student);
        verify(studentRepository).save(student);
        System.out.println("Test testUpdate");
    }

    /**
     * Test of selectById method, of class StudentServiceImpl.
     */
    @Test
    public void getStudentTest() {

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        studentService.getStudent(id);
        verify(studentRepository).findById(id);


        System.out.println("Test testSelectById");

    }

    /**
     * Test of delete method, of class StudentServiceImpl.
     */
    @Test
    public void testDelete() {
          studentService.deletStudent(id);
        verify(studentRepository).deleteById(id);
        System.out.println("Test testDelete");

    }

    /**
     * Test of select method, of class StudentServiceImpl.
     */
    @Test
    public void testSelect() {

        System.out.println("Test testSelect");
        studentService.getall();
          verify(studentRepository).findAll();
    }


}