package com.CGS.admission.studentAdmission.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="F_MARKS")
@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="marks_id")
    private Long marksId;
    @Column(name="MARKS_SESSION")
    private String session;
    private double marks1;
    private double marks2;

    @ManyToOne
    @JoinColumn(name = "Student_ID")
    private Student st;

   @ManyToOne
   @JoinColumn(name = "Course_ID")
    private Course cs;
}
