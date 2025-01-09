package com.example.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    // Get all account holders
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderRepository.findAll();
    }

    // Get account holder by ID
    public Optional<AccountHolder> getAccountHolderById(Long id) {
        return accountHolderRepository.findById(id);
    }

    // Add or update an account holder
    public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    // Delete an account holder
    public void deleteAccountHolder(Long id) {
        accountHolderRepository.deleteById(id);
    }
}
