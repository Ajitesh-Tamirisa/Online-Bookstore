package com.example.masterRobot.repository;

import com.example.masterRobot.entity.CustOrder;
import com.example.masterRobot.entity.store_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustOrderRepo extends JpaRepository<CustOrder, Long> {
}
