package com.CGS.admission.studentAdmission.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @AllArgsConstructor @NoArgsConstructor @ToString
public class Course {
    @Id
    @Column(name = "C_ID")
    private long courseId;
    @Column(name = "C_NAME")
    private String courseName;
    @Column(name = "CREDIT_NUMBER")
    private long creditNumber;

}
