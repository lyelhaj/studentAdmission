package com.CGS.admission.studentAdmission;

import com.CGS.admission.studentAdmission.entities.*;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

//import java.util.Date;

@SpringBootApplication
public class StudentAdmissionApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StudentAdmissionApplication.class, args);
	}




}
