package br.com.rodrigo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.rodrigo.api.config.AppConfig;

@RestController
public class FilmeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppConfig appConfig;


    @GetMapping("/top250")
    public String getTop250Filmes() {

        ResponseEntity<String> response =
                this.restTemplate.getForEntity(appConfig.getBaseUrl(), String.class);

        return response.getBody();
    }
}
