package br.com.rodrigo.api.controller;

import java.util.List;

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
    public ListaDeFilmes getTop250Filmes() {

        ResponseEntity<ListaDeFilmes> response =
                this.restTemplate.getForEntity(appConfig.getBaseUrl(), ListaDeFilmes.class);

        return response.getBody();
    }

    record Filme(String title, String image, String year, String imDbRating){}
    public record ListaDeFilmes(List<Filme> items){}
}
