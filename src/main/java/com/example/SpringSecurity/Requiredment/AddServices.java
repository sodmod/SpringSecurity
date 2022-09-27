package com.example.SpringSecurity.Requiredment;

import com.example.SpringSecurity.Responsibilities.ApplicationUserRole;
import com.example.SpringSecurity.student.StudentServices;
import com.example.SpringSecurity.student.Students;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.SpringSecurity.Responsibilities.ApplicationUserRole.STUDENT;

@AllArgsConstructor
@Service
public class AddServices {
    @Autowired
    private final StudentServices studentServices;

    public String signUpStudent(AddRequirement addRequirement){
        String student = studentServices.addStudent(
                new Students(addRequirement.getUsername(), addRequirement.getPassword(), STUDENT
                )
        );
        return student;
    }
}
