package com.example.SpringSecurity.Admin;

import com.example.SpringSecurity.Responsibilities.ApplicationUserRole;
import com.example.SpringSecurity.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.SpringSecurity.Responsibilities.ApplicationUserRole.*;

@AllArgsConstructor
@Service
public class AdminService implements UserDetailsService {

    private final AdminRepo repo;

    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    ApplicationUserRole applicationUserRole;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User is not found"));
    }

    public String addAdmin(Admin admin){
        String encodeed = passwordEncoder.bCryptPasswordEncoder().encode(admin.getPassword());
        admin.setPassword(encodeed);
        Admin ad = new Admin(admin.getUsername(), admin.getPassword(), ADMIN);
        repo.save(ad);
        return "success";
    }
}
