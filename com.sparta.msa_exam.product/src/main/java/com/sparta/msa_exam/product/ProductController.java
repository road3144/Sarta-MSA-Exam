package com.sparta.msa_exam.product;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	@Value("${server.port}")
	private String port;
	private final ProductService productService;

	@PostMapping("/products")
	public ProductResponseDto addProduct(
		HttpServletResponse response,
		@RequestBody ProductRequestDto requestDto
	) {
		response.setHeader("Server-Port", port);
		return productService.createProduct(requestDto);
	}

	@GetMapping("/products")
	public List<ProductResponseDto> getAllProducts(
		HttpServletResponse response
	) {
		response.setHeader("Server-Port", port);
		return productService.getAllProducts();
	}
}
