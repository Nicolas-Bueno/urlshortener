package nb.tech.urlshortener.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import nb.tech.urlshortener.service.UrlShortenerService;

@RestController
public class UrlShortenerController {

    @Autowired
    UrlShortenerService urlShortenerService;

    private LocalDateTime lastExpirationCheckTime;

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<String> shortener(@RequestBody String url){
        String shortenedUrl = urlShortenerService.shortenUrl(url);
        return new ResponseEntity<>(shortenedUrl, HttpStatus.OK);
    }

}
