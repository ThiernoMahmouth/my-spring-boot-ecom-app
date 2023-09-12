package com.kowlytech.customerservice.services;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class MessageByLocaleServiceImpl implements MessageByLocaleService
{
    private MessageSource messageSource;

    @Override
    public String getMessage(String code)
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    @Override
    public String getMessage(String code, Object[] data)
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, data, locale);
    }
}
