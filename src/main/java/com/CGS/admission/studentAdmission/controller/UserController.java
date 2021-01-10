package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.User;
import com.CGS.admission.studentAdmission.repositories.UserRepository;
import com.CGS.admission.studentAdmission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/notAuthorized")
    public String error(){
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/register")
    public String register(Model md){
User user=new User();
md.addAttribute(user);
        return "addUser";
    }


    @PostMapping("/addUser")
    public String addUser( @RequestParam User  user){
        userService.registerNewUserAccount(user);
        return "login";
    }

}
