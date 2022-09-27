package com.example.SpringSecurity.Entity;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class InfoService {
    private final InfoRepo repo;

    public String addInfo(@NotNull Info info){
        Info in = new Info(info.getName(), info.getPhoneNumber(), info.getMessage());
        repo.save(in);
        return "success";
    }
}
