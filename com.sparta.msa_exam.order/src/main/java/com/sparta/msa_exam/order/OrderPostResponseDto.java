package com.sparta.msa_exam.order;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderPostResponseDto {
	Long id;

	public static OrderPostResponseDto from(Order order) {
		return OrderPostResponseDto.builder()
			.id(order.getId())
			.build();
	}
}
