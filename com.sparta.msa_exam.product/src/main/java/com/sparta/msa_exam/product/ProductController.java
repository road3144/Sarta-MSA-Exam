package com.sparta.msa_exam.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping("/products")
	public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
		return productService.createProduct(requestDto);
	}

	@GetMapping("/products")
	public List<ProductResponseDto> getAllProducts() {
		return productService.getAllProducts();
	}
}
