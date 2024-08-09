package com.sparta.msa_exam.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
	Optional<OrderProduct> findByOrderAndProductId(Order order, Long productId);
}
