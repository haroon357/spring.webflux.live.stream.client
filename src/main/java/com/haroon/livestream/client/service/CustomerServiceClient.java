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
    /**
     * This method invoke another service that should be running locally at http://localhost:8080/customer that return TEXT_EVENT_STREAM of customer objects "
     * please see https://github.com/haroon357/spring.webflux.live.stream.server
     * it prcess the stream result and insert them in another customer_copy table
     *
     */
    public String processCustomerByConsumingLiveStream() {
        log.info("getting customers");
        //use non-blocking web client to get TEXT_EVENT_STREAM over http and convert it to Flux
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
