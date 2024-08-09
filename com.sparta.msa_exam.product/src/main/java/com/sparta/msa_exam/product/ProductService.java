package com.sparta.msa_exam.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public ProductResponseDto createProduct(ProductRequestDto requestDto) {
		Product product = Product.builder()
			.name(requestDto.getProductName())
			.supplyPrice(requestDto.getProductSupplyPrice())
			.build();
		return ProductResponseDto.from(productRepository.save(product));
	}

	public List<ProductResponseDto> getAllProducts() {
		return productRepository.findAll()
			.stream()
			.map(ProductResponseDto::from)
			.toList();
	}
}
