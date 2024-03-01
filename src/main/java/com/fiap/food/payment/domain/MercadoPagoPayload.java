package com.fiap.food.payment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MercadoPagoPayload {
    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;
}
