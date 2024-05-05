package nb.tech.urlshortener.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nb.tech.urlshortener.entity.UrlShortenerEntity;
import nb.tech.urlshortener.repository.UrlShortenerRepository;
@AllArgsConstructor
@Service
public class UrlShortenerService {

    @Autowired
    private final UrlShortenerRepository urlShortenerRepository;

    public String shortenUrl(String originUrl){
        String shortenedUrl = RandomStringUtils.randomAlphanumeric(5,10);

        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(1);

        UrlShortenerEntity entity = new UrlShortenerEntity();
        entity.setUrlOrigin(originUrl);
        entity.setUrlShorterner(shortenedUrl);
        entity.setExpirationTime(expirationTime);
        urlShortenerRepository.save(entity);

        return shortenedUrl;

    }

    
    @Scheduled(fixedRate = 60000) // Executa a cada minuto
    public void deleteExpiredUrls() {
        LocalDateTime now = LocalDateTime.now();
        List<UrlShortenerEntity> expiredUrls = urlShortenerRepository.findByExpirationTimeBefore(now);
        urlShortenerRepository.deleteAll(expiredUrls);
    }

    @Scheduled(fixedRate = 60000)
    public void executeTask() {
        // Este método será executado a cada minuto
        System.out.println("Tarefa agendada executada a cada minuto.");
    }


}
