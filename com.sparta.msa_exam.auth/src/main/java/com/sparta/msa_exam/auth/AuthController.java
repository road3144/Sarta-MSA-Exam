package com.sparta.msa_exam.auth;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
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

	@Value("${server.port}")
	private String port;

	@GetMapping("/auth/signIn")
	public ResponseEntity<?> createAuthenticationToken(
		HttpServletResponse response,
		@RequestParam String user_id
	) {
		response.setHeader("Server-Port", port);
		return ResponseEntity.ok(new AuthResponse(authService.createAccessToken(user_id)));
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	static class AuthResponse {
		private String access_token;

	}
}
