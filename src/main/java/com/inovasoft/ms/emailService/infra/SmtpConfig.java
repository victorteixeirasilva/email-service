package com.inovasoft.ms.emailService.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmtpConfig {

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.hostinger.com");
//        mailSender.setPort(465);
//        mailSender.setUsername("adm@inovasoft.tech");
//        mailSender.setPassword("Vi$230803");
//        mailSender.setProtocol("SMTPS");
//        mailSender.getJavaMailProperties().put("mail.transport.protocol", "smtps");
//        mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
//        mailSender.getJavaMailProperties().put("mail.smtp.ssl.enable", "true");
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587); // Use 587 para TLS ou 465 para SSL
        mailSender.setUsername("victorteixeira2308@gmail.com");
        mailSender.setPassword("bhgc zctq dsnv zhul");
        mailSender.getJavaMailProperties().put("mail.transport.protocol", "smtp");
        mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true"); // Necessário para TLS
        return mailSender;
    }
}
