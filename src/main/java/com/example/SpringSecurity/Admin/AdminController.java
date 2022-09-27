package com.example.SpringSecurity.Admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService service;

    @PostMapping(path = "add")
    public String addAdmin(@RequestBody Admin admin){
        return service.addAdmin(admin);
    }

}
