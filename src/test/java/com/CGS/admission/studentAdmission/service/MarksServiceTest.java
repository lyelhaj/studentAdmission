package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.*;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QPageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MarksServiceTest {
    Student student=new  Student(id, "Ahmed", "Sidi", "45 Montreal", "Montreal", "asidi@gmail.com",Gender.MALE, null,5142261052L,null);
    Course course=new Course(25L,"java",8,1999,null);
    private static Long id;
    @Mock
    Marks marks;

    @Mock
    MarksRepository marksRepository;

    @InjectMocks
    MarksService marksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMarks() {
        when(marksRepository.findById(id)).thenReturn(Optional.of(marks));
    assertEquals(marksService.getMarks(id),marks);
    }

    @Test
    void getAll() {

        when(marksRepository.findAll()).thenReturn(Stream.of(new Marks(2L,Semestre.JANUARY,100, 70, student, course),
                new Marks(5L,Semestre.JANUARY,20, 70, student, course)).collect(Collectors.toList()));
     assertEquals(2,marksService.getAll().size());
    }

    @Test
    void addMarksTest() {
       Marks marks=new Marks(5L,Semestre.JANUARY,20, 70, student, course);
      when(marksRepository.save(marks)).thenReturn(marks);
       assertEquals(marksService.addMarks(marks),marks);
    }

    @Test
    void deleteMarksTest() {
       marksService.deleteMarks(id);
       verify(marksRepository).deleteById(id);
    }

    @Test
    void updateMarksTest() {
        Marks marks=new Marks(5L,Semestre.JANUARY,20, 70, student, course);
        when(marksRepository.save(marks)).thenReturn(marks);
        assertEquals(marksService.updateMarks(id,marks),marks);


    }

    @Test
    void getByLastNameTest() {
        String ln=TestUtil.generateRandomString();
        student.setLastName(ln);
        Marks m1=new Marks(5L,Semestre.JANUARY,20, 70, student, course);
        Marks m2=new Marks(5L,Semestre.JANUARY,20, 70, student, course);
        List<Marks> marks=new ArrayList<>();
        marks.add(m1);
        marks.add(m2);
        Page<Marks> marksPage= new PageImpl<Marks>(marks,PageRequest.of(1,2),2);
        when(marksRepository.findByStLastNameContains(ln,PageRequest.of(1,2))).thenReturn(marksPage);
        assertEquals(marksService.getByLastName(ln,PageRequest.of(1,2)).getContent(),marksPage.getContent());

    }
}