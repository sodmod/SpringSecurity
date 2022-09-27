package com.example.SpringSecurity.Entity;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/info")
public class InfoController {

    private InfoService service;

    @PostMapping(path = "add")
    public String addInfo(@RequestBody Info info){
        return service.addInfo(info);
    }
}
