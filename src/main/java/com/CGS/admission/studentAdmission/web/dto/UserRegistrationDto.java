package com.CGS.admission.studentAdmission.web.dto;

import com.CGS.admission.studentAdmission.entities.Role;
import com.CGS.admission.studentAdmission.entities.RoleType;
import com.CGS.admission.studentAdmission.entities.User;

import java.util.Collection;

public class UserRegistrationDto  {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private Collection<Role> roles;

    public UserRegistrationDto (String firstName, String lastName, String email, String password,boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public UserRegistrationDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
