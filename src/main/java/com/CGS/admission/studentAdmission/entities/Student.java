package com.CGS.admission.studentAdmission.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

@Table(name="F_STUDENT")
public @Data @NoArgsConstructor @AllArgsConstructor  @ToString class Student {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "S_ID")
    private long studentId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "S_CITY")
    private String city;
    @Column(name = "EMAIL")
    private String email;
    //@OneToMany(mappedBy = "st")
   // private List<Marks> marks=new ArrayList<Marks>();

}
