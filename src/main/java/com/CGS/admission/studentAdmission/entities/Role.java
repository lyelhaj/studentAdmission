package com.CGS.admission.studentAdmission.entities;
//import netscape.security.Privilege;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="F_Role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}