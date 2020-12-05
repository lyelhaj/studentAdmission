package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;





public interface MarksRepository extends JpaRepository<Marks, Long>{
	//public Page<Marks> findByStLastNameContains(String kw,Pageable pageable) ;
}
