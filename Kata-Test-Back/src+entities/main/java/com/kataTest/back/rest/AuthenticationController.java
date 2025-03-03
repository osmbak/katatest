package com.kataTest.back.rest;

import com.kataTest.back.dto.auth.AuthenticationRequest;
import com.kataTest.back.dto.auth.AuthenticationResponse;
import com.kataTest.back.dto.auth.RegisterRequest;
import com.kataTest.back.enteties.AuthResponseDto;
import com.kataTest.back.enteties.LoginRequestDto;
import com.kataTest.back.enteties.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
/*    private final AuthentificationService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        System.out.println("register web");
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        System.out.println("authenticate web");
        return ResponseEntity.ok(service.authenticate(request));
    }*/
private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.login(registerRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }
}
