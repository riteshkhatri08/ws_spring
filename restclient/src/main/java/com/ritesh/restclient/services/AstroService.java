package com.ritesh.restclient.services;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ritesh.restclient.json.AstroResponse;

@Service
public class AstroService {

    private final WebClient webClient;
    private final RestTemplate restTemplate;

    @Autowired
    public AstroService(WebClient.Builder webClientBuilder, RestTemplateBuilder restTemplateBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.open-notify.org/").build();
        this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(2)).build();
    }

    public AstroResponse getAstroResponse() {

        return this.webClient.get().uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofSeconds(15));

    }

    public AstroResponse getAstroResponseRestTemplate() {

        return this.restTemplate.getForObject("http://api.open-notify.org/astros.json", AstroResponse.class);
    }

}
