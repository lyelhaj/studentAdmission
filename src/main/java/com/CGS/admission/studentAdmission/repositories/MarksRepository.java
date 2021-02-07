package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long>{

	//@Query("from Marks as m WHERE m.st.lastName like :x ")
	//public Page<Marks> search(@Param("x") String kw, Pageable pageable) ;
    public Page<Marks> findByStLastNameContains( String kw, Pageable pageable) ;
    public List<Marks> findByStStudentId(Long id) ;
    public List<Marks> findByCsCourseId(Long id) ;

}
