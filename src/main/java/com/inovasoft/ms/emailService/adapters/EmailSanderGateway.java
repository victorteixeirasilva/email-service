package com.inovasoft.ms.emailService.adapters;

public interface EmailSanderGateway {
    void sendEmail(String to, String subject, String body);
}
