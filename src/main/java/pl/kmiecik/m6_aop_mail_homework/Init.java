package pl.kmiecik.m6_aop_mail_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m6_aop_mail_homework.email.application.GmailService;
import pl.kmiecik.m6_aop_mail_homework.film.application.port.FilmUseCase;
import pl.kmiecik.m6_aop_mail_homework.film.domain.Film;

@Component
class Init {

    private final GmailService emailService;
    private final FilmUseCase filmService;

    @Autowired
    public Init(GmailService emailService, FilmUseCase filmService) {
        this.emailService = emailService;
        this.filmService = filmService;
    }

    // @EventListener(ApplicationReadyEvent.class)
    void sendEmail() {
        emailService.sendSimpleMessage("krzysztof_kmiecik@wp.pl", "test", "ciało");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {

        filmService.addFilm(new Film("Matrix", 1990, "Wachowscy"));
        filmService.addFilm(new Film("Matrix2", 1995, "Wachowscy"));
        filmService.addFilm(new Film("Matrix3", 1997, "Wachowscy"));
    }
}
