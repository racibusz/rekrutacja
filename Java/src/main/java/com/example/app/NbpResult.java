package com.example.app;

import java.util.List;

public class NbpResult {
    private String table, currency, code;
    private List<Rate> rates;

    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Rate getRate() {
        return (Rate) rates.get(0);
    }

    public String getCurrency() {
        return currency;
    }

    public String getTable() {
        return table;
    }

    public String getCode() {
        return code;
    }
}
