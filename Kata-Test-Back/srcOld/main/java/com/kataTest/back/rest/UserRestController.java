package com.kataTest.back.rest;



import com.kataTest.back.dto.auth.LoginDto;
import com.kataTest.back.dto.auth.RegisterDto;
import com.kataTest.back.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserRestController {


    private final IUserService iUserService ;

    //RessourceEndPoint:http://localhost:8090/api/user/register
    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDto registerDto)
    { return  iUserService.register(registerDto);}

    //RessourceEndPoint:http://localhost:8087/api/user/authenticate
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDto loginDto)
    { return  iUserService.authenticate(loginDto);}



}
