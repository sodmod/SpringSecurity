package com.example.SpringSecurity.Requiredment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/students")
public class AddController {

    AddServices addServices;
    @PostMapping(path = "add")
    public String addStud(@RequestBody AddRequirement addRequirement){
        return addServices.signUpStudent(addRequirement);
    }
}
