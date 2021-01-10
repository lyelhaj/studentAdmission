package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);
}
