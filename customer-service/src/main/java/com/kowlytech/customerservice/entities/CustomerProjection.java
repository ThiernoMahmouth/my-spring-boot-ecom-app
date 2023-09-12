package com.kowlytech.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customerProjection", types = Customer.class)
public interface CustomerProjection
{
    public Long getId();
    public String getName();
}
