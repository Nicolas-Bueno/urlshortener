package nb.tech.urlshortener.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nb.tech.urlshortener.entity.UrlShortenerEntity;

public interface UrlShortenerRepository extends JpaRepository<UrlShortenerEntity, Long>{

    List<UrlShortenerEntity> findByExpirationTimeBefore(LocalDateTime expirationTime);
    UrlShortenerEntity findByUrlShorterner(String urlShorterner);

}
