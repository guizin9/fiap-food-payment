package com.fiap.food.payment.controller;

import com.fiap.food.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService checkoutService;

    @PostMapping("/payment")
    public ResponseEntity<String> processarPagamento() {
        String resultadoPagamento = checkoutService.processarPagamento();
        return ResponseEntity.status(HttpStatus.OK).body(resultadoPagamento);
    }
}

