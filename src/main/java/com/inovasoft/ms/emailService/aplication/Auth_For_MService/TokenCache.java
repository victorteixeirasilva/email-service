package com.inovasoft.ms.emailService.aplication.Auth_For_MService;

import com.inovasoft.ms.emailService.aplication.Auth_For_MService.dto.AuthAuthenticationRequest;
import com.inovasoft.ms.emailService.aplication.Auth_For_MService.dto.AuthLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TokenCache {

    @Value("${inevolving.super.secret}")
    private String SUPER_SECRET;

    @Autowired
    private AuthForMServiceClient authForMServiceClient;

    public String getToken(MicroServices microServices){
        AuthAuthenticationRequest request = new AuthAuthenticationRequest(MicroServices.EMAIL_SERVICE.getValue(), SUPER_SECRET);
        AuthLoginResponse response = authForMServiceClient.login(microServices.getValue(), request);
        return response.BearerToken();
    }

}
