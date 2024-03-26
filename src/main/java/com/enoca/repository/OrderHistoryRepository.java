package com.enoca.repository;

import com.enoca.domain.Cart;
import com.enoca.domain.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long>, JpaSpecificationExecutor<OrderHistory> {

    List<OrderHistory> findAllByOrderCustomerId(Integer customerId);

    Optional<OrderHistory> findById(Integer orderHistoryId);

}
