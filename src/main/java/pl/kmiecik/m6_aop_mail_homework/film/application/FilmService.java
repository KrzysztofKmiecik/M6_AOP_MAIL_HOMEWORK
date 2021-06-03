package pl.kmiecik.m6_aop_mail_homework.film.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.m6_aop_mail_homework.film.application.port.FilmUseCase;
import pl.kmiecik.m6_aop_mail_homework.film.domain.Film;
import pl.kmiecik.m6_aop_mail_homework.film.domain.FilmRepository;

import java.util.List;

@Service
class FilmService implements FilmUseCase {

    private final FilmRepository repository;

    @Autowired
    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> getAllFilms() {
        return repository.getAll();
    }

    @Override
    public Film addFilm(Film film) {
        Film myFilm = film;
        repository.save(myFilm);
        return myFilm;
    }

}
