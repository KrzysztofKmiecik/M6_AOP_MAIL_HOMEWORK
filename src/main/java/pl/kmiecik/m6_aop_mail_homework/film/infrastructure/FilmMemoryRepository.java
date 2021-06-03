package pl.kmiecik.m6_aop_mail_homework.film.infrastructure;

import org.springframework.stereotype.Repository;
import pl.kmiecik.m6_aop_mail_homework.film.domain.Film;
import pl.kmiecik.m6_aop_mail_homework.film.domain.FilmRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
class FilmMemoryRepository implements FilmRepository {

    List<Film> filmList=new ArrayList<>();

    @Override
    public List<Film> getAll(){
        return filmList;
    }

    @Override
    public void save(Film film){
        filmList.add(film);
    }
}
