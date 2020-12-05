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
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "F_COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long courseId;
    @Column(name = "C_NAME")
    private String courseName;
    @Column(name = "CREDIT_NUMBER")
    private long creditNumber;
   // @OneToMany(mappedBy = "cs")
    //private List<Marks> marks=new ArrayList<Marks>();

}
