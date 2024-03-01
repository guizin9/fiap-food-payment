package com.fiap.food.payment.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoService {
    private String accessToken;
    public MercadoPagoService(@Value("${mercadopago.access-token}") String accessToken) {
        this.accessToken = accessToken;
        MercadoPagoConfig.setAccessToken(this.accessToken);
    }

    public void processarPagamentoAprovado(String paymentId) throws Exception {
        System.out.println("Pagamento Aprovado. ID do pagamento: " + paymentId);
    }
}
