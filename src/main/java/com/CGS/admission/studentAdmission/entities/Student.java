package com.CGS.admission.studentAdmission.entities;




import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity

@Table(name="F_STUDENT")
//@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public  class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "S_ID")
    private Long studentId;
    @Column(name = "FIRST_NAME")
    @Size(min = 2,max = 20)
    private String firstName;
    @Column(name = "LAST_NAME")
    @Size(min = 2,max = 20)
    private String lastName;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "S_CITY")
    private String city;

    @Column(name = "EMAIL")
    @Email
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Gender type;
    private Date dateOfBirth;
    private Long telephone;

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    @OneToMany(mappedBy = "st", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
   private List<Marks> marks=new ArrayList<Marks>();

    public Student() {
    }

    public Student(Long studentId, String firstName, String lastName, String adress, String city, String email, Gender type, Date dateOfBirth, Long telephone, List<Marks> marks) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
        this.email = email;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.marks = marks;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getType() {
        return type;
    }

    public void setType(Gender type) {
        this.type = type;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
