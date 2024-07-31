package com.example.bankprojectbackend.Entity;

import javax.persistence.*;

@Entity
@Table(name="STAJBANKLOGINUSERS")
public class StajBankLoginUsers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="USERNAME")
    private String username;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password; }
}
