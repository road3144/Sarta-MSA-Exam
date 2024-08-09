package com.sparta.msa_exam.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/order")
	public OrderPostResponseDto createOrder(@RequestBody OrderPostRequestDto requestDto) {
		return orderService.createOrder(requestDto);
	}

	@PutMapping("/order/{orderId}")
	public OrderResponseDto updateOrder(@PathVariable Long orderId, @RequestBody OrderPutRequestDto requestDto) {
		return orderService.appendProduct(orderId, requestDto);
	}

	@GetMapping("/order/{orderId}")
	public OrderResponseDto getOrderById(@PathVariable Long orderId) {
		return orderService.getOrderById(orderId);
	}
}
