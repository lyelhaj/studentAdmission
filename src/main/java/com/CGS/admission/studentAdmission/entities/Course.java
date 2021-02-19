package com.CGS.admission.studentAdmission.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "F_COURSE")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private Long courseId;
    @Column(name = "C_NAME")
    private String courseName;
    @Column(name = "CREDIT_NUMBER")
    @Max(8) @Min(1)
    private long creditNumber;
    @Min(2010)
   @Max(9999)
    private int year;
   @OneToMany(mappedBy = "cs", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
   private List<Marks> marks=new ArrayList<Marks>();
   @ManyToOne
   @JoinColumn(name="teacher_id")
   private Teacher teacher;

    public Course(Long courseId, String courseName, long creditNumber, int year, List<Marks> marks) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditNumber = creditNumber;
        this.year = year;
        this.marks = marks;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
