package pl.kmiecik.m6_aop_mail_homework.film.application.port;

import pl.kmiecik.m6_aop_mail_homework.film.domain.Film;

import java.util.List;

public interface FilmUseCase {
    List<Film> getAllFilms();

    Film addFilm(Film film);
}
