package com.sparta.msa_exam.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductRequestDto {
	private String productName;
	private Integer productSupplyPrice;
}
