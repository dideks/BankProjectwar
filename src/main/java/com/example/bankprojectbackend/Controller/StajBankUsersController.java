package com.example.bankprojectbackend.Controller;

import com.example.bankprojectbackend.Entity.StajBankUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StajBankUsersController {

    private final com.example.bankprojectbackend.Repository.StajBankUsersRepository stajBankUsersRepository;

    @Autowired
    public StajBankUsersController(com.example.bankprojectbackend.Repository.StajBankUsersRepository stajBankUsersRepository) {
        this.stajBankUsersRepository = stajBankUsersRepository;
    }

    @GetMapping("/accounts")
    public List<StajBankUsers> getAllUsers() {
        return stajBankUsersRepository.findAll();
    }

    @PostMapping("/insertUser")
    public StajBankUsers insertUser(@RequestBody StajBankUsers user) {
        return stajBankUsersRepository.save(user);
    }

    @PutMapping("/updateBalance")
    public String updateBalance(@RequestParam String musteriHesapno, @RequestParam int additionalAmount) {
        try {
            Long hesapno = Long.valueOf(musteriHesapno);
            Optional<StajBankUsers> userOptional = stajBankUsersRepository.findById(hesapno);
            if (userOptional.isPresent()) {
                StajBankUsers user = userOptional.get();
                int newBalance = user.getMusteriBakiye() + additionalAmount;
                user.setMusteriBakiye(newBalance);
                stajBankUsersRepository.save(user);
                return "Balance updated successfully.";
            } else {
                return "User not found.";
            }
        } catch (NumberFormatException e) {
            return "Invalid account number format.";
        }
    }

    @PutMapping("/withdrawal")
    public String withdrawal(@RequestParam String musteriHesapno, @RequestParam int subtractedAmount) {
        try {
            Long hesapno = Long.valueOf(musteriHesapno);
            Optional<StajBankUsers> userOptional = stajBankUsersRepository.findById(hesapno);
            if (userOptional.isPresent()) {
                StajBankUsers user = userOptional.get();
                int currentBalance = user.getMusteriBakiye();
                if (subtractedAmount > currentBalance) {
                    return "Insufficient funds.";
                }
                int newBalance = currentBalance - subtractedAmount;
                user.setMusteriBakiye(newBalance);
                stajBankUsersRepository.save(user);
                return "Withdrawal successful.";
            } else {
                return "User not found.";
            }
        } catch (NumberFormatException e) {
            return "Invalid account number format.";
        }
    }

    @PostMapping("/currentBalance")
    public Integer currentBalance(@RequestParam String musteriHesapno) {
        try {
            Long hesapno = Long.valueOf(musteriHesapno);
            Optional<StajBankUsers> userOptional = stajBankUsersRepository.findById(hesapno);
            if (userOptional.isPresent()) {
                return userOptional.get().getMusteriBakiye();
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid account number format.");
        }
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String musteriHesapno, @RequestParam long musteriTCNo) {
        try {
            Long hesapno = Long.valueOf(musteriHesapno);
            Optional<StajBankUsers> userOptional = stajBankUsersRepository.findById(hesapno);
            if (userOptional.isPresent()) {
                StajBankUsers user = userOptional.get();
                if (user.getMusteriTCNo() == musteriTCNo) {
                    stajBankUsersRepository.deleteById(hesapno);
                    return "User deleted successfully.";
                } else {
                    return "TC No does not match.";
                }
            } else {
                return "User not found.";
            }
        } catch (NumberFormatException e) {
            return "Invalid account number format.";
        }
    }
}
