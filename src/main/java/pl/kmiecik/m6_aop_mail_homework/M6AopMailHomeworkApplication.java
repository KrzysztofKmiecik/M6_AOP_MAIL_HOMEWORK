package pl.kmiecik.m6_aop_mail_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class M6AopMailHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(M6AopMailHomeworkApplication.class, args);
    }

}
