package com.CGS.admission.studentAdmission.entities;

import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class courseTest {

    private Course course;
    private static Long id=100l;
   private String name;
   private static Long creditNumber=30l;
   private int year ;

    @BeforeEach
    void setUp() {
        course=new Course();
       name=TestUtil.generateRandomString();
       year=TestUtil.generateRandomNumber();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gettersAndSettersTest() {
        course.setCourseName(name);
        course.setCreditNumber(creditNumber);
        course.setYear(year);

        assertNotNull(course.getCourseName());
        assertNotNull(course.getCreditNumber());
        assertNotNull(course.getYear());

    }




}
