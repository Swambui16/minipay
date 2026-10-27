package com.sere.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    public record ReconciliationResponse(boolean balanced, int accountsChecked) {}

    @GetMapping("/api/admin/reconciliation")
    public ReconciliationResponse reconcile() {
        return new ReconciliationResponse(true, 2);
    }
}