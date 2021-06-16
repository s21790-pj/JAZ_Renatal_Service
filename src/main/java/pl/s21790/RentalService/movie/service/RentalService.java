package pl.s21790.RentalService.movie.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.s21790.RentalService.movie.model.Movie;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
        String fooResourceUrl = String.format("http://localhost:8080/movies/%s", id);
        return restTemplate.getForEntity(fooResourceUrl, Movie.class).getBody();
    }

    public void returnMovie(Long id) {
        String fooResourceUrl = String.format("http://localhost:8080/movies/%s/true", id);
        restTemplate.put(fooResourceUrl, null);
    }

    public void rentMovie(Long id) {
        String fooResourceUrl = String.format("http://localhost:8080/movies/%s/false", id);
        restTemplate.put(fooResourceUrl, null);
    }


}
