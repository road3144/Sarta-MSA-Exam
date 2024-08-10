package com.sparta.msa_exam.order;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class OrderResponseDto {

	Long id;
	List<Integer> productIds;

	public static OrderResponseDto from(Order order) {
		return OrderResponseDto.builder()
			.id(order.getId())
			.productIds(order.getProductIds().stream()
				.map(OrderProduct::getProductId)
				.map(Long::intValue)
				.toList())
			.build();
	}

}
