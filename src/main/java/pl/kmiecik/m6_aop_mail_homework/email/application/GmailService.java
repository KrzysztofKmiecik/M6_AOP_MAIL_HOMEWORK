package pl.kmiecik.m6_aop_mail_homework.email.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.kmiecik.m6_aop_mail_homework.email.application.port.EmailUseCase;


/**
 * https://www.baeldung.com/spring-email
 */

@Service
public class GmailService implements EmailUseCase {

    private final JavaMailSender emailSender;


    @Autowired
    public GmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendSimpleMessage(final String to, final String subject, final String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
