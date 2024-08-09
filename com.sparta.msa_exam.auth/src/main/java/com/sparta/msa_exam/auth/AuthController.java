package com.sparta.msa_exam.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@GetMapping("/auth/signIn")
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String user_id) {
		return ResponseEntity.ok(new AuthResponse(authService.createAccessToken(user_id)));
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	static class AuthResponse {
		private String access_token;

	}
}
