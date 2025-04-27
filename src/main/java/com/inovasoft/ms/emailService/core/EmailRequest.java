package com.inovasoft.ms.emailService.core;

public record EmailRequest(String to, String subject, String body) {
}
