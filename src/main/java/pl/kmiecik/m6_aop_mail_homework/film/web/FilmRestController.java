package pl.kmiecik.m6_aop_mail_homework.film.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kmiecik.m6_aop_mail_homework.email.application.SendEmail;
import pl.kmiecik.m6_aop_mail_homework.film.application.port.FilmUseCase;
import pl.kmiecik.m6_aop_mail_homework.film.domain.Film;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/films")
class FilmRestController {
    Logger log = LoggerFactory.getLogger(FilmRestController.class);

    private final FilmUseCase filmService;

    @Autowired
    public FilmRestController(FilmUseCase filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Film> getFilms() {
        log.info("GET");
        return filmService.getAllFilms();
    }

    @PostMapping
    @SendEmail
    public ResponseEntity<Void> addFilm(@RequestBody @Valid FilmCommand command) {
        log.info("POST");
        Film myAddedFilm = filmService.addFilm(command.toFilm());
        if (myAddedFilm != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    private static class FilmCommand {

        @NotBlank
        private final String title;
        @NotNull
        private final Integer year;
        @NotBlank
        private final String producer;

        public FilmCommand(final String title, final Integer year, final String producer) {
            this.title = title;
            this.year = year;
            this.producer = producer;
        }

        public String getTitle() {
            return title;
        }

        public Integer getYear() {
            return year;
        }

        public String getProducer() {
            return producer;
        }

        public Film toFilm() {
            return new Film(this.getTitle(), this.getYear(), this.getProducer());
        }
    }
}

