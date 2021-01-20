package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.MyUserDetails;
import com.CGS.admission.studentAdmission.entities.Role;
import com.CGS.admission.studentAdmission.entities.RoleType;
import com.CGS.admission.studentAdmission.entities.User;
import com.CGS.admission.studentAdmission.repositories.UserRepository;
import com.CGS.admission.studentAdmission.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getEmail()
                , userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(), passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.isEnabled(), userRegistrationDto.getRoles());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        /*return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }*/
        return new MyUserDetails(user);
    }
}
