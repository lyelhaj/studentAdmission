package com.CGS.admission.studentAdmission;

import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import com.CGS.admission.studentAdmission.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StudentAdmissionApplicationTests {
	@Mock
	Student student;

	@Mock
	StudentRepository studentRepository;
	@InjectMocks
	StudentService studentService;


	@Test
	void contextLoads() {

	}

}
