package com.CGS.admission.studentAdmission.repositories;

import com.CGS.admission.studentAdmission.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Override
    void delete(Role role);
}
