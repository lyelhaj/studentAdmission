package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
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
class CourseServiceTest {
    private static final Long id=2l;
    @Mock
    private Marks marks;
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
        Course cs=new Course(id,"Math",7,2019,null);
        when(courseRepository.save(cs)).thenReturn(cs);
        assertEquals(cs,courseService.addCourse(cs));
    }

    /**
     * Test of update method, of class StudentServiceImpl.
     */
    @Test
    public void testUpdateUpdate() {
        Course cs=new Course(id,"Math",7,2019,null);
when(courseRepository.save(cs)).thenReturn(cs);
assertEquals(cs,courseService.updateCourse(id,cs));

    }

    /**
     * Test of selectById method, of class StudentServiceImpl.
     */
    @Test
    public void getCourseTest() {

        when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        assertEquals(course,courseService.getCourse(id));

    }

    /**
     * Test of delete method, of class StudentServiceImpl.
     */
    @Test
    public void testDeleteCourse() {
        courseService.deleteCourse(id);
        verify(courseRepository,times(1)).deleteById(id);

    }

    /**
     * Test of select method, of class StudentServiceImpl.
     */
    @Test
    public void testGetAllCourse() {
        //Mocking the finAll behavior
        when(courseRepository.findAll()).thenReturn(Stream.of(new Course(25L,"java",8,1999,null),
                new Course(20L,"Oracle",6,2005,null)).collect(Collectors.toList()));

        assertEquals(2,courseService.getAll().size());
    }

@Test
    public void testGetCourseByName(){
String name= TestUtil.generateRandomString();
    List<Course> courses= new ArrayList<>();
    courses.add(new Course(20L,name,6,2005,null));
    Page<Course> coursePage= new PageImpl<>(courses,PageRequest.of(1,1),1);
when(courseRepository.findByCourseNameContains(name, PageRequest.of(1,1))).thenReturn(coursePage);
assertEquals(courseService.getByName(name,PageRequest.of(1,1)).getContent(),coursePage.getContent());
}

}