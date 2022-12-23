package com.haroon.livestream.client.controller;

import com.haroon.livestream.client.service.CustomerServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LiveStreamClientDemoController {

    private final CustomerServiceClient customerService;

    /**
     * Controller to demo consumer of live stream over http
     * @return
     */
    @GetMapping(value = "/demo-live-stream-client", produces = "text/plain")
    public String getCustomersAsLiveStream() {
        return customerService.processCustomerByConsumingLiveStream();
    }

}
