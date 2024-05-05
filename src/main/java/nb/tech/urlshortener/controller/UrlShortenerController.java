package nb.tech.urlshortener.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import nb.tech.urlshortener.service.UrlShortenerService;

@RestController
public class UrlShortenerController {

    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortener(@RequestBody String url, HttpServletRequest servletRequest){
        String shortenedUrl = urlShortenerService.shortenUrl(url);
        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", shortenedUrl);
        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortenedUrl) {
        String originalUrl = urlShortenerService.findByShortUrl(shortenedUrl);
        if (originalUrl != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(originalUrl));
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
