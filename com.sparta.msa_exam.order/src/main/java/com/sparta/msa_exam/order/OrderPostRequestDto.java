package com.sparta.msa_exam.order;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrderPostRequestDto {
	private String name;
	private List<Long> productIds;
}
