package com.CGS.admission.studentAdmission.entities;

import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private static Long id=100l;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private static Long telephone=4302550235l;
    private String email;
    private String gender;
    private Date birthdate;

    @BeforeEach
    void setUp() {
        student=new Student();
        id= TestUtil.generateRandomLong();
        firstName=TestUtil.generateRandomString();
        lastName=TestUtil.generateRandomString();
        address=TestUtil.generateRandomString();
        city=TestUtil.generateRandomString();
        email=TestUtil.generateRandomString();
        gender=TestUtil.generateRandomString();
        birthdate=new Date(2000,05,05);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gettersAndSettersTest() {
        student.setTelephone(telephone);
        student.setFirstName(firstName);
        student.setAdress(address);
        student.setDateOfBirth(birthdate);

        assertNotNull(student.getTelephone());
        assertNotNull(student.getFirstName());
        assertNotNull(student.getAdress());
        assertNotNull(student.getDateOfBirth());

    }






}