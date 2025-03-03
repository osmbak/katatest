package com.kataTest.back.service;



import com.kataTest.back.dto.auth.LoginDto;
import com.kataTest.back.dto.auth.RegisterDto;
import com.kataTest.back.enteties.Role;
import com.kataTest.back.enteties.User;
import org.springframework.http.ResponseEntity;


public interface IUserService {
   //ResponseEntity<?> register (RegisterDto registerDto);
 //  ResponseEntity<BearerToken> authenticate(LoginDto loginDto);

   String authenticate(LoginDto loginDto);
   ResponseEntity<?> register (RegisterDto registerDto);
   Role saveRole(Role role);

   User saverUser (User user) ;
}
