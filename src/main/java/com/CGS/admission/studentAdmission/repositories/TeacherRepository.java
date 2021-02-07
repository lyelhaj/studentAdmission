package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Page<Teacher> findByLastNameContains(String ln, Pageable pageable);
}
