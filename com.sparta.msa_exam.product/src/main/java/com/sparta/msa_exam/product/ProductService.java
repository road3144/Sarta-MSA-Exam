package com.sparta.msa_exam.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
		Product product = Product.builder().build();
		return ProductResponseDto.from(product);
	}

	public List<ProductResponseDto> getAllProducts() {
		return productRepository.findAll()
			.stream()
			.map(ProductResponseDto::from)
			.toList();
	}
}
