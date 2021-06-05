package pl.s21790.RentalService.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s21790.RentalService.movie.model.Movie;
import pl.s21790.RentalService.movie.service.RentalService;

@RestController
@RequestMapping("")
public class RentalRestController {

    private final RentalService rentalService;

    public RentalRestController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @PostMapping("rental/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PostMapping("rental/available/{id}")
    public void returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
    }


}
