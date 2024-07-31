package com.example.bankprojectbackend.Repository;

import com.example.bankprojectbackend.Entity.StajBankLoginUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StajBankLoginRepository extends JpaRepository <StajBankLoginUsers,Long> {
    List<StajBankLoginUsers> findByUsernameAndPassword(String username, String password);
}
