package com.CGS.admission.studentAdmission.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class MarksTest {

    @Mock
    Student student;
    @Mock
    Course course;
    @InjectMocks
    Marks marks;
    @BeforeEach
    public void setUp() {
        Marks marks=new Marks();
        marks.setMarksId(15l);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void setAndGetStudentTest(){
        marks.setSt(student);
        assertNotNull(marks.getSt());
    }

    @Test
    public void setAndGetCourseTest(){
      // course= new Course(12l,"hghjg",32,2019,null);
marks.setCs(course);
assertNotNull(marks.getCs());
    }

    @Test
    void testAvarge(){
    Student student=new Student();
    Course course=new Course();
    Marks marks=new Marks(1l, Semestre.JANUARY, 80,60, student, course);
    assertEquals(70,marks.avarege());

}

    @Test
    void testGrade(){
        Student student=new Student();
        Course course=new Course();
        Marks marks1=new Marks(1l, Semestre.JANUARY, 80,60, student, course);
        assertEquals('B',marks1.grade());
        Marks marks2=new Marks(1l, Semestre.JANUARY, 40,60, student, course);
        assertEquals('F',marks2.grade());
        Marks marks3=new Marks(1l, Semestre.JANUARY, 90,100, student, course);
        assertEquals('A',marks3.grade());
        Marks marks4=new Marks(1l, Semestre.JANUARY, 66,70, student, course);
        assertEquals('C',marks4.grade());

    }

}


