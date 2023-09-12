package com.kowlytech.customerservice.services;

public interface MessageByLocaleService
{
    String getMessage(String code);
    String getMessage(String code, Object[] data);
}
