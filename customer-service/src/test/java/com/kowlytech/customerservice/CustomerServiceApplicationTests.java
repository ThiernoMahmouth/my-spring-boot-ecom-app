package com.kowlytech.customerservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kowlytech.customerservice.entities.Customer;
import com.kowlytech.customerservice.web.CustomerController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceApplicationTests
{
    @Autowired
    private MockMvc mockMvc;

    @Before()
    public void setup()
    {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(CustomerController.class)
                .build();
    }

    @Test
    public void addNewCustomerTest() throws Exception
    {
        // Build requestBody
        Random random = new Random();
        int number = random.nextInt();
        Customer customer = Customer.builder()
                .name("TEST" + number)
                .email("test" + number + "@test.com")
                .build();

        // Call Controller endpoint
        mockMvc
            .perform(MockMvcRequestBuilders
                .post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJson(customer))
                .accept(MediaType.APPLICATION_JSON_VALUE));
                //.andExpect(result -> result.getResponse().getStatus().)

    }
    @Test
    void contextLoads() {
    }

    public static String asJson(final Object object)
    {
        try
        {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
