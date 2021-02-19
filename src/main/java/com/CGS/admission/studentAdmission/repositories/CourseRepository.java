package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Course;
import com.CGS.admission.studentAdmission.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
	public Page<Course> findByCourseNameContains(String kw,Pageable pageable) ;
	public List<Course> findByTeacherId(Long id);
}

