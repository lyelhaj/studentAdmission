package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Gender;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

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
        Student st1=new  Student(id, "Ahmed", "Sidi", "45 Montreal", "Montreal", "asidi@gmail.com",Gender.MALE, null,5142261052L,null);
        when(studentRepository.save(st1)).thenReturn(st1);
        assertEquals(studentService.addStudent(st1),st1);


    }

    /**
     * Test of update method, of class StudentServiceImpl.
     */
    @Test
    public void testUpdateStudent() {
        Student student=new  Student(id, "Ahmed", "Sidi", "45 Montreal", "Montreal", "asidi@gmail.com", Gender.MALE, null,5142261052L,null);
        when(studentRepository.save(student)).thenReturn(student);
       assertEquals( studentService.updatStudent(id,student),student);


    }

    /**
     * Test of selectById method, of class StudentServiceImpl.
     */
    @Test
    public void getStudentTest() {
Student student=new  Student(id, "Ahmed", "Sidi", "45 Montreal", "Montreal", "asidi@gmail.com", Gender.MALE, null,5142261052L,null);
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
       assertEquals(studentService.getStudent(id),student);

    }

    /**
     * Test of delete method, of class StudentServiceImpl.
     */
    @Test
    public void testDelete() {
          studentService.deletStudent(id);
        verify(studentRepository).deleteById(id);


    }

    /**
     * Test of select method, of class StudentServiceImpl.
     */
    @Test
    public void testGetAll() {
        when(studentRepository.findAll()).thenReturn(Stream.of(
               new  Student(id, "Ahmed", "Sidi", "45 Montreal", "Montreal", "asidi@gmail.com",Gender.MALE, null,5142261052L,null),
                new  Student(2L, "dag", "aly", "45 Montreal", "Montreal", "asidi@gmail.com",Gender.MALE, null,5142261052L,null)
       ).collect(Collectors.toList()));
        assertEquals(studentService.getall().size(),2);

    }

    @Test
    public void getByLastNameTest(){
        String lastName= TestUtil.generateRandomString();
        List<Student> students=new ArrayList<>();
        students.add( new  Student(id, "Ahmed", lastName, "45 Montreal", "Montreal", "asidi@gmail.com",Gender.MALE, null,5142261052L,null));
        Page<Student> studentPage=new PageImpl<>(students,PageRequest.of(1,1),1);
        when(studentRepository.findByLastNameContains(lastName,PageRequest.of(1,1))).thenReturn(studentPage);
        assertEquals(studentService.getByLastName(lastName,PageRequest.of(1,1)).getContent(),studentPage.getContent());



    }

}