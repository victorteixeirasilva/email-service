package com.inovasoft.ms.emailService.controllers;

import com.inovasoft.ms.emailService.aplication.EmailSanderService;
import com.inovasoft.ms.emailService.core.EmailRequest;
import com.inovasoft.ms.emailService.core.exceptions.EmailServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Tag(name = "Email Sander", description = "Gerenciamento de Envio de Emails")
@RestController
@RequestMapping("/ms/email")
public class EmailSenderController {

    private final EmailSanderService emailSanderService;

    @Autowired
    public EmailSenderController(EmailSanderService emailSanderService){
        this.emailSanderService = emailSanderService;
    }

    @Operation(
            summary =
                    "Enviando um email",
            description =
                    "Retorna uma mensagem informando se o e-mail foi enviado ou não com sucesso!")
    @Async("asyncExecutor")
    @PostMapping()
    public CompletableFuture<ResponseEntity<String>> sendEmail(@RequestBody EmailRequest request){
        try {
            this.emailSanderService.sendEmail(request.to(), request.subject(), request.body());
            return CompletableFuture.completedFuture(ResponseEntity.ok("email send sucessfully"));
        } catch (EmailServiceException exception) {
            log.error("ERROR: {}",exception.getMessage());
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email"));
        }
    }
}
