package com.sparta.msa_exam.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductResponseDto {
	private Long id;
	private String name;
	private Integer supplyPrice;

	public static ProductResponseDto from(Product product) {
		return ProductResponseDto.builder()
			.id(product.getId())
			.name(product.getName())
			.supplyPrice(product.getSupplyPrice())
			.build();
	}
}
