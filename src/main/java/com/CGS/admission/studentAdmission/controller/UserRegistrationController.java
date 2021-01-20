package com.CGS.admission.studentAdmission.controller;

import com.CGS.admission.studentAdmission.entities.Role;
import com.CGS.admission.studentAdmission.entities.RoleType;
import com.CGS.admission.studentAdmission.service.UserService;
import com.CGS.admission.studentAdmission.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
//@RequestMapping("/registration")
public class UserRegistrationController {
private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    @GetMapping("/registration")
    public String getRegistrationForm(){
return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto user,@RequestParam String role){

       user.setRoles(Arrays.asList(new Role(role)));
        userService.save(user);

return "redirect:/registration?success";

    }



}
