package com.example.bankprojectbackend.Repository;

import com.example.bankprojectbackend.Entity.StajBankUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StajBankUsersRepository extends JpaRepository<StajBankUsers,Long> {

}
