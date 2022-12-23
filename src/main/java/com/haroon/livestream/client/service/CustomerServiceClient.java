package com.haroon.livestream.client.service;


import com.haroon.livestream.client.model.CustomerCopy;
import com.haroon.livestream.client.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceClient {


    private final WebClient webClient;

    private final CustomerRepository customerRepository;

    private final static String BASE_URL = "http://localhost:8080/";
    @SneakyThrows
    public String processCustomerByConsumingLiveStream() {
        log.info("getting customers");
        webClient.get()
                .uri("/customer")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(CustomerCopy.class)
                .subscribe(this::process);
               // .subscribe(customerCopy -> log.info("customer = "+ customerCopy));

        return "SUCCESS";
    }

    private void process(CustomerCopy customerCopy) {
        customerRepository.save(customerCopy);
        log.info("inserted customer in customer_copy table" +customerCopy);

    }
}
