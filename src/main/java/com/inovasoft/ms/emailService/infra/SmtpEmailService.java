package com.inovasoft.ms.emailService.infra;

import com.inovasoft.ms.emailService.adapters.EmailSanderGateway;
import com.inovasoft.ms.emailService.core.exceptions.EmailServiceException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
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
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(emailUsername);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//
//        try {
//            mailSender.send(message);
//        } catch (Exception e) {
//            throw new EmailServiceException("Failure while sending email");
//        }
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setFrom(emailUsername);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // 👈 true sinaliza que o corpo é HTML

            mailSender.send(message);
        } catch (Exception e) {
            throw new EmailServiceException("Failure while sending email");
        }

    }
}
