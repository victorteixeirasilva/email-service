package com.inovasoft.ms.emailService.aplication;

import com.inovasoft.ms.emailService.adapters.EmailSanderGateway;
import com.inovasoft.ms.emailService.core.EmailSanderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSanderService implements EmailSanderUseCase {

    private final EmailSanderGateway emailSanderGateway;

    @Autowired
    public EmailSanderService(EmailSanderGateway gateway){
        this.emailSanderGateway = gateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSanderGateway.sendEmail(to, subject, body);
    }

}
