package com.enoca.repository;

import com.enoca.domain.Cart;
import com.enoca.model.enums.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>, JpaSpecificationExecutor<Cart> {

    Optional<Cart> findById(Integer cartId);

    Optional<Cart> findByCustomerIdAndCartStatus(Integer customerId, CartStatus cartStatus);
}
