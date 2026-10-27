package com.sere.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class TransferController {

    public record TransferRequest(String sourceAccount, String destinationAccount,
                                  BigDecimal amount, String channel) {}
    public record TransferResponse(String reference, String status,
                                   String sourceAccount, String destinationAccount,
                                   BigDecimal amount) {}

    // 5. Send money
    @PostMapping("/api/transfers")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferResponse createTransfer(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody TransferRequest request) {
        return new TransferResponse("TRF-001", "COMPLETED",
                request.sourceAccount(), request.destinationAccount(), request.amount());
    }

    // 6. Check a transfer
    @GetMapping("/api/transfers/{reference}")
    public TransferResponse getTransfer(@PathVariable String reference) {
        return new TransferResponse(reference, "COMPLETED",
                "WALLET-001", "BANK-002", new BigDecimal("1500.00"));
    }

    // 8. Reverse a transfer
    @PostMapping("/api/transfers/{reference}/reverse")
    public TransferResponse reverseTransfer(@PathVariable String reference) {
        return new TransferResponse(reference, "REVERSED",
                "WALLET-001", "BANK-002", new BigDecimal("1500.00"));
    }
}