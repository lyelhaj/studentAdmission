package com.CGS.admission.studentAdmission.repositories;



import com.CGS.admission.studentAdmission.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	//@Query("from Student s where s.studentId=id")
	public Page<Student> findByLastNameContains(String ln, Pageable pageable);
}
