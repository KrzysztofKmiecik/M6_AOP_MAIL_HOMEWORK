package pl.kmiecik.m6_aop_mail_homework.film.domain;

import java.util.List;

public interface FilmRepository {
    List<Film> getAll();

    void save(Film film);
}
