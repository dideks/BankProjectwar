package com.example.bankprojectbackend.Controller;

import com.example.bankprojectbackend.Entity.StajBankLoginUsers;
import com.example.bankprojectbackend.Repository.StajBankLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class StajBankLoginController {
    @Autowired
    private  StajBankLoginRepository stajBankLoginRepository;


    @PostMapping("/getUserInfo")
    public List<StajBankLoginUsers> getUserInfo(@RequestBody StajBankLoginUsers userlist) {

        List<StajBankLoginUsers> myEntityList = stajBankLoginRepository.findAll();
        List<StajBankLoginUsers> result = new ArrayList<>();

        for (StajBankLoginUsers entity : myEntityList) {
            if(entity.getUsername().equals(userlist.getUsername())&&entity.getPassword().equals(userlist.getPassword())){
                result.add(entity);
            }
        }
        return result;
    }

}
