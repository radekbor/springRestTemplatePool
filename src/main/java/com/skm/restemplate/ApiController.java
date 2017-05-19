package com.skm.restemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    private static final String WAIT_URL = "https://httpbin.org/delay/%d";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/wait")
    public boolean callWaiter() throws URISyntaxException {
        String URI  = String.format(WAIT_URL, 10L);
        LOGGER.info("wait method invoke");
        RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(URI));
        restTemplate.exchange(requestEntity, Object.class);
        return true;
    }
}
