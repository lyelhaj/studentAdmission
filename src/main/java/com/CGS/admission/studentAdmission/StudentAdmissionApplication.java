package com.CGS.admission.studentAdmission;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.entities.Student;
import com.CGS.admission.studentAdmission.repositories.CourseRepository;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAdmissionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentAdmissionApplication.class, args);
	}

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MarksRepository marksRepository;
	@Override
	public void run(String... args )throws Exception{


		Student student1=new Student(1l,"Christiano","Ronaldo","199 boulevard deslaurntide laval quebec h7k 2m9", "Montreal","uel@gmail.com");
		studentRepository.save(student1);
		Student student2=new Student(2l,"Karim","Benzema","200 boulevard dagenai Montreal quebec h7k 2m9", "Laval","karim.benzema@gmail.com");
		studentRepository.save(student2);
		Student student3=new Student(3l,"Luca","Modric","199 boulevard deslaurntide laval quebec h7k 2m9", "Montreal","luka@yahoo.fr");
		studentRepository.save(student3);
		Student student4=new Student(4l,"Sergio","Ramos","199 boulevard deslaurntide laval quebec h7k 2m9", "Montreal","ramos.s@yahoo.fr");
		studentRepository.save(student4);


		Course course1=new Course(1l,"Java",12l);
		Course course2=new Course(2l,"C++",30l);
		Course course3=new Course(3l,"Php",6l);
		Course course4=new Course(4l,"Python",12l);


		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);


		marksRepository.save(new Marks(1l,"Summer",80,70,student1,course1));
		marksRepository.save(new Marks(2l,"Spring",90,60,student2,course2));
		marksRepository.save(new Marks(3l,"Spring",96,70,student3,course3));
		marksRepository.save(new Marks(4l,"Spring",50,40,student4,course4));


		courseRepository.findAll().forEach(c->{
			System.out.println(c.toString());
		});

		studentRepository.findAll().forEach(c->{
			System.out.println(c.toString());
		});

		marksRepository.findAll().forEach(c->{
			c.toString();
		});
	}

}
