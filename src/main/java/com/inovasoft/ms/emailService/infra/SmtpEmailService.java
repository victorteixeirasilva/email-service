package com.inovasoft.ms.emailService.infra;

import com.inovasoft.ms.emailService.adapters.EmailSanderGateway;
import com.inovasoft.ms.emailService.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService implements EmailSanderGateway {

    private final JavaMailSender mailSender;

    @Value("${email.username}")
    private String emailUsername;

    @Autowired
    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new EmailServiceException("Failure while sending email");
        }
    }
}
