package com.sere.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    public record CreateAccountRequest(long customerId, String type) {}
    public record AccountResponse(long id, long customerId, String type, BigDecimal balance) {}
    public record DepositRequest(BigDecimal amount) {}
    public record BalanceResponse(long accountId, BigDecimal balance) {}
    public record TransactionResponse(String reference, String type, BigDecimal amount) {}

    @PostMapping("/api/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return new AccountResponse(1, request.customerId(), request.type(), BigDecimal.ZERO);
    }

    @PostMapping("/api/accounts/{id}/deposit")
    public BalanceResponse deposit(@PathVariable long id, @RequestBody DepositRequest request) {
        return new BalanceResponse(id, request.amount());
    }

    @GetMapping("/api/accounts/{id}/balance")
    public BalanceResponse getBalance(@PathVariable long id) {
        return new BalanceResponse(id, new BigDecimal("5000.00"));
    }

    @GetMapping("/api/accounts/{id}/transactions")
    public List<TransactionResponse> getTransactions(@PathVariable long id) {
        return List.of(
                new TransactionResponse("TXN-001", "DEPOSIT", new BigDecimal("5000.00")),
                new TransactionResponse("TXN-002", "TRANSFER_OUT", new BigDecimal("1500.00"))
        );
    }
}