package com.example.SpringSecurity.Admin;

import com.example.SpringSecurity.Responsibilities.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Collections;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@Data
@Entity
public class Admin implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "Admin_sequence",
            sequenceName = "Admin_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Admin_sequence")
    private Long id;
    private String username;
    private String password;
    private ApplicationUserRole applicationUserRole;

    public Admin(String username, String password, ApplicationUserRole applicationRole){
        this.username = username;
        this.password = password;
        this.applicationUserRole = applicationRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(applicationUserRole.ADMIN.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
