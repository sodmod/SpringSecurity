package com.example.SpringSecurity.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
public class Info {

    @Id
    @SequenceGenerator(
            name = "Info_sequence",
            sequenceName = "Info_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Info_sequence")
    private Long id;
    private String name;
    private String phoneNumber;
    private String message;

    public Info(String name, String phoneNumber, String message){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

}
