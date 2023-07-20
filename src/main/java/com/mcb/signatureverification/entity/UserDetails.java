package com.mcb.signatureverification.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userdetails")
@Data
@NoArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "username")
    private String username;
    private String password;
    public UserDetails(String username, String password){
        this.username = username;
        this.password = password;

    }
}
