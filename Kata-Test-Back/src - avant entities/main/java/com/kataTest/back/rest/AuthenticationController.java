package com.kataTest.back.rest;

import com.kataTest.back.dto.auth.AuthenticationRequest;
import com.kataTest.back.dto.auth.AuthenticationResponse;
import com.kataTest.back.dto.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthentificationService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        System.out.println("register web");
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        System.out.println("authenticate web");
        return ResponseEntity.ok(service.authenticate(request));
    }
}
