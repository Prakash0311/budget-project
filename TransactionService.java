package com.example.springboot;

//import com.example.springboot.Transaction;
//import com.example.springboot.AccountHolder;
//import com.example.springboot.TransactionRepository;
//import com.example.springboot.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

//    @Autowired
//    private AccountHolderRepository accountHolderRepository;

    // Get all transactions for a specific account holder
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountHolder_Id(accountId);
    }

    // Add a new transaction
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get transaction by ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Delete a transaction by ID
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    // Generate statement for a given account holder within a date range
//    public List<Transaction> getStatement(Long accountId, LocalDate startDate, LocalDate endDate) {
//        return transactionRepository.findByAccountHolderIdAndTxnDateBetween(accountId, startDate, endDate);
//    }
}

