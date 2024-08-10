package com.sparta.msa_exam.order;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${server.port}")
	private String port;

	@PostMapping("/order")
	public OrderPostResponseDto createOrder(
		HttpServletResponse response,
		@RequestBody OrderPostRequestDto requestDto
	) {
		response.setHeader("Server-Port", port);
		return orderService.createOrder(requestDto);
	}

	@PutMapping("/order/{orderId}")
	public OrderResponseDto updateOrder(
		HttpServletResponse response,
		@PathVariable Long orderId,
		@RequestBody OrderPutRequestDto requestDto
	) {
		response.setHeader("Server-Port", port);
		return orderService.appendProduct(orderId, requestDto);
	}

	@GetMapping("/order/{orderId}")
	public OrderResponseDto getOrderById(
		HttpServletResponse response,
		@PathVariable Long orderId
	) {
		response.setHeader("Server-Port", port);
		return orderService.getOrderById(orderId);
	}
}
