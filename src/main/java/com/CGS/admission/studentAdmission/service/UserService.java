package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.User;
import com.CGS.admission.studentAdmission.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface  UserService extends UserDetailsService {
   User save(UserRegistrationDto userRegistrationDto);
}
