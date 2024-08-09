package com.sparta.msa_exam.order;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderProductRepository orderProductRepository;

	@Transactional
	public OrderPostResponseDto createOrder(OrderPostRequestDto requestDto) {
		Order order = orderRepository.save(
			Order.builder()
				.name(requestDto.getName())
				.build()
		);

		List<OrderProduct> products = orderProductRepository.saveAll(
			requestDto.getProductIds().stream()
				.map(id -> OrderProduct.builder()
					.productId(id)
					.order(order).build()
				)
				.toList()
		);

		return OrderPostResponseDto.from(order);
	}

	@Transactional
	public OrderResponseDto getOrderById(Long orderId) {
		return OrderResponseDto.from(
			orderRepository.findById(orderId)
				.orElseThrow(EntityNotFoundException::new)
		);
	}

	@Transactional
	public OrderResponseDto appendProduct(Long orderId, OrderPutRequestDto requestDto) {
		Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
		order.getProductIds().add(
			orderProductRepository.save(
				OrderProduct.builder()
					.order(order)
					.productId(requestDto.productId)
					.build()
			)
		);
		return OrderResponseDto.from(order);
	}
}
