package com.example.springboot;

//import com.example.springboot.AccountHolder;
//import com.example.springboot.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account-holders")
@CrossOrigin(origins = "http://localhost:3000") // Allowing React app to connect
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    // Get all account holders
    @GetMapping
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderService.getAllAccountHolders();
    }

    // Get an account holder by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountHolder> getAccountHolderById(@PathVariable Long id) {
        Optional<AccountHolder> accountHolder = accountHolderService.getAccountHolderById(id);
        return accountHolder.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add or update an account holder
    @PostMapping
    public AccountHolder saveAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.saveAccountHolder(accountHolder);
    }

    // Delete an account holder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountHolder(@PathVariable Long id) {
        Optional<AccountHolder> accountHolder = accountHolderService.getAccountHolderById(id);
        if (accountHolder.isPresent()) {
            accountHolderService.deleteAccountHolder(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
