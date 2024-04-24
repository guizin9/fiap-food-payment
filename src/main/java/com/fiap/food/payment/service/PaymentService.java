package com.fiap.food.payment.service;

import com.fiap.food.payment.domain.Payment;
import com.fiap.food.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public String processarPagamento() {
        String status = simularPagamento();
        Payment payment = new Payment();
        payment.setStatus(status);
        paymentRepository.save(payment);

        return "Pagamento " + status;
    }

    private String simularPagamento() {
        Random random = new Random();
        int result = random.nextInt(2);
        return result == 1 ? "aprovado" : "reprovado";
    }
}