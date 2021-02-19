package com.CGS.admission.studentAdmission.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="F_MARKS")
//@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class Marks {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="marks_id")
    private Long marksId;
    @Column(name="MARKS_SESSION")
    @Enumerated(EnumType.ORDINAL)
    private Semestre season;

    @NotNull(message = "Marks cannot be empty") @Min(value = 0, message = "The min value is 0") @Max(value = 100, message = "max value is 100")
    private double marks1;
    @NotNull(message = "Marks cannot be empty") @Min(value = 0, message = "The min value is 0") @Max(value = 100, message = "max value is 100")
    private double marks2;

    @ManyToOne
    @JoinColumn(name = "Student_ID")
    private Student st;

   @ManyToOne
   @JoinColumn(name = "Course_ID")
    private Course cs;

    public Marks() {
    }

    public Marks(Long marksId, Semestre season, double marks1, double marks2, Student st, Course cs) {
        this.marksId = marksId;
        this.season = season;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.st = st;
        this.cs = cs;
    }

    public Long getMarksId() {
        return marksId;
    }

    public void setMarksId(Long marksId) {
        this.marksId = marksId;
    }

    public Semestre getSeason() {
        return season;
    }

    public void setSeason(Semestre season) {
        this.season = season;
    }

    public double getMarks1() {
        return marks1;
    }

    public void setMarks1(double marks1) {
        this.marks1 = marks1;
    }

    public double getMarks2() {
        return marks2;
    }

    public void setMarks2(double marks2) {
        this.marks2 = marks2;
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public Course getCs() {
        return cs;
    }

    public void setCs(Course cs) {
        this.cs = cs;
    }

    public double avarege() {

        double av = (marks1 + marks2) / 2;
        return av;

    }

    //returning grade letter
    public char grade() {
        if (avarege() >= 90) {
            return 'A';
        } else if (avarege() >= 70) {
            return 'B';
        } else if (avarege() >= 60) {
            return 'C';
        } else {
            return 'F';
        }
    }

}
