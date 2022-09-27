package com.example.SpringSecurity.student;

import com.example.SpringSecurity.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServices implements UserDetailsService {

    private final StudentRepo repo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }

    public String addStudent(Students students){
        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(students.getPassword());
        students.setPassword(encodedPassword);
        repo.save(students);
        return "okay";
    }

}
