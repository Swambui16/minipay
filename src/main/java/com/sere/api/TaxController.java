package com.sere.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

    // A small class that just holds the result data
    public record TaxResult(double grossPay, double taxRate, double taxAmount, double netPay) {}

    @GetMapping("/tax")
    public TaxResult calculateTax(@RequestParam double grossPay) {
        double taxRate;

        if (grossPay > 40000) {
            taxRate = 0.30;
        } else if (grossPay > 30000) {
            taxRate = 0.25;
        } else if (grossPay > 20000) {
            taxRate = 0.15;
        } else if (grossPay > 10000) {
            taxRate = 0.10;
        } else {
            taxRate = 0;
        }

        double taxAmount = grossPay * taxRate;
        double netPay = grossPay - taxAmount;

        return new TaxResult(grossPay, taxRate, taxAmount, netPay);
    }
}
