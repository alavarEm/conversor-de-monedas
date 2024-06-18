package com.ealavar.model;

public class Moneda {
    String conversion_rates;

    public String getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(String base_code) {
        this.conversion_rates = base_code;
    }
}
