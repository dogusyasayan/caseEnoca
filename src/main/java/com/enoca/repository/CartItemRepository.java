package com.enoca.repository;

import com.enoca.domain.CartItem;
import com.enoca.model.enums.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>, JpaSpecificationExecutor<CartItem> {

    List<CartItem> findAllByCartIdAndProductId(Integer cartId, Integer productId);
}
