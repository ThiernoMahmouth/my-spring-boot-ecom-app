package com.kowlytech.customerservice.web;

import com.kowlytech.customerservice.services.MessageByLocaleService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers/test")
@AllArgsConstructor
public class InternationalisationController
{

    private MessageByLocaleService messageByLocaleService;

    @GetMapping
    public String sayHelloSimple()
    {
        return messageByLocaleService.getMessage("app.greeting.simple");
    }
    @GetMapping("/{name}")
    public String sayHelloWithParam(@PathVariable String name)
    {
        Object[] params = new Object[1];
        params[0] = name;
        return messageByLocaleService.getMessage("app.greeting.withParam", params);
    }
}
