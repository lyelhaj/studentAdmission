package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CourseRepository extends JpaRepository<Course, Long> {
	//public Page<Course> findByNameContains(String kw,Pageable pageable) ;
}
