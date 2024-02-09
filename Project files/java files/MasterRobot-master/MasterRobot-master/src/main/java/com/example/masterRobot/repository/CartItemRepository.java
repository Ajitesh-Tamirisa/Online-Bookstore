package com.example.masterRobot.repository;

import com.example.masterRobot.entity.CartItem;
import com.example.masterRobot.entity.store_items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
