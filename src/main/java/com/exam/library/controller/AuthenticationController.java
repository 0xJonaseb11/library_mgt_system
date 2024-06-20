package com.exam.library.controller;

import com.exam.library.dto.AuthenticationRequest;
import com.exam.library.dto.AuthenticationResponse;
import com.exam.library.dto.RegisterRequest;
import com.exam.library.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name= "Authentication")
public class AuthenticationController {
    private final AuthenticationService service;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegisterRequest request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }


    @GetMapping("activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) throws MessagingException {
        String response = service.forgotPassword(email);
        return ResponseEntity.ok(response);

    }


    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @RequestParam("password") String password){
        return service.resetPassword(token,password);
    }



}
