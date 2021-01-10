package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourseServiceTest {
    private static final Long id=2l;
    @Mock
    private Course course;
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private CourseService courseService;

    public CourseServiceTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of insert method, of class StudentServiceImpl.
     */
    @Test
    public void addCourseTst() {
        courseService.addCourse(course);
        verify(courseRepository).save(course);
        System.out.println("Test addStudent");
    }

    /**
     * Test of update method, of class StudentServiceImpl.
     */
    @Test
    public void testUpdateUpdate() {

        courseService.updateCourse(id,course);
        verify(courseRepository).save(course);
        System.out.println("Test testUpdate");
    }

    /**
     * Test of selectById method, of class StudentServiceImpl.
     */
    @Test
    public void getCourseTest() {

        when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        courseService.getCourse(id);
        verify(courseRepository).findById(id);


        System.out.println("Test testSelectById");

    }

    /**
     * Test of delete method, of class StudentServiceImpl.
     */
    @Test
    public void testDeleteCourse() {
        courseService.deleteCourse(id);
        verify(courseRepository).deleteById(id);
        System.out.println("Test testDelete");

    }

    /**
     * Test of select method, of class StudentServiceImpl.
     */
    @Test
    public void testGetAllCourse() {

        System.out.println("Test testSelect");
        courseService.getAll();
        verify(courseRepository).findAll();
    }



}