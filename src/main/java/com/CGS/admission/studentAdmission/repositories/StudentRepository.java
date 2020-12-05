package com.CGS.admission.studentAdmission.repositories;



import com.CGS.admission.studentAdmission.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;





public interface StudentRepository extends JpaRepository<Student, Long> {

	//public Page<Student> findByLastNameContains(String kw,Pageable pageable) ;
}
