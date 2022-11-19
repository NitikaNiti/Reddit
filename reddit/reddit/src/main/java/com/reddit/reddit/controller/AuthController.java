package com.reddit.reddit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.reddit.dto.RegisterRequest;
import com.reddit.reddit.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<>("user is registered succesfull", HttpStatus.OK);
		
	}

}
