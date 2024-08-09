package com.sparta.msa_exam.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductRequestDto {
	private int productId;
	private String productName;
	private Integer productSupplyPrice;
}
