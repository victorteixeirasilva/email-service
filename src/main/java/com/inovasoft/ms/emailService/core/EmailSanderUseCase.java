package com.inovasoft.ms.emailService.core;

public interface EmailSanderUseCase {
    void sendEmail(String to, String subject, String body);
}
