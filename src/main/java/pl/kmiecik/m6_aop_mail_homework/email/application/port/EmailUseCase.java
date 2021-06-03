package pl.kmiecik.m6_aop_mail_homework.email.application.port;

public interface EmailUseCase {
    void sendSimpleMessage(
            String to, String subject, String text);
}
