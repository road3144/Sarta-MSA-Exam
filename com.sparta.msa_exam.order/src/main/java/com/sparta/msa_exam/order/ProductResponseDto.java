package com.sparta.msa_exam.order;

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
}
