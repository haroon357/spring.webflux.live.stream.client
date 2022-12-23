package com.haroon.livestream.client.service;


import com.haroon.livestream.client.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceClient {


    private final WebClient webClient;

    private final static String BASE_URL = "http://localhost:8080/";
    @SneakyThrows
    public String getCustomers() {
        log.info("getting customers");
        webClient.get()
                .uri("/customer")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(Customer.class)
                .subscribe(customer -> log.info("customer = "+customer));

        return "SUCCESS";
    }
}
