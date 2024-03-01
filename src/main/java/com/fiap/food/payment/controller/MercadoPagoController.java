package com.fiap.food.payment.controller;

import com.fiap.food.payment.domain.MercadoPagoPayload;
import com.fiap.food.payment.service.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mercadopago")
public class MercadoPagoController {

    private final MercadoPagoService mercadoPagoService;

    @Autowired
    public MercadoPagoController(MercadoPagoService mercadoPagoService) {
        this.mercadoPagoService = mercadoPagoService;
    }

    @PostMapping("/webhook/mercadopago")
    public void receiveWebhook(@RequestBody MercadoPagoPayload webhookPayload) {
        System.out.println("Webhook recebido do Mercado Pago: " + webhookPayload);
        String status = webhookPayload.getStatus();
        String paymentId = webhookPayload.getId();
        if ("approved".equals(status)) {
            System.out.println("O pagamento foi aprovado. ID do pagamento: " + paymentId);
            try {
                mercadoPagoService.processarPagamentoAprovado(paymentId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("rejected".equals(status)) {
            System.out.println("O pagamento foi recusado. ID do pagamento: " + paymentId);
            try {
                mercadoPagoService.processarPagamentoAprovado(paymentId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

