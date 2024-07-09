package com.wit.accountApp.dto;

public record AccountResponse(long id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}
