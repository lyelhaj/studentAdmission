package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.User;
import com.CGS.admission.studentAdmission.repositories.RoleRepository;
import com.CGS.admission.studentAdmission.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {


        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private RoleRepository roleRepository;



        // API

        public User registerNewUserAccount(User user) {

            return userRepository.save(user);
        }


        public void saveRegisteredUser(final User user) {
            userRepository.save(user);
        }


        public void deleteUser(final User user) {
            passwordEncoder.encode(user.getPassword());
            userRepository.delete(user);
        }


        public User findUserByEmail(final String email) {
            return userRepository.findByEmail(email);
        }


        public Optional<User> getUserByID(final long id) {
            return userRepository.findById(id);
        }


        public void changeUserPassword(final User user, final String password) {
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }


        public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
            return passwordEncoder.matches(oldPassword, user.getPassword());
        }

        private boolean emailExists(final String email) {
            return userRepository.findByEmail(email) != null;
        }

}
