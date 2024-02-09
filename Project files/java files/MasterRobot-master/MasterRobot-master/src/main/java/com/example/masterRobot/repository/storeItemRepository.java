package com.example.masterRobot.repository;

import com.example.masterRobot.entity.store_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface storeItemRepository extends JpaRepository<store_items, Long> {

    @Query(nativeQuery = true, value = "SELECT createCustOrder FROM DUAL")
    long createCustOrder();

    @Procedure(procedureName = "setShippingDate")
    void setShippingDate(long orderId, Date shippedDate);
    @Procedure(procedureName = "createOrderLineItem")
    void createOrderLineItem(long custOrderId, long itemId, long customerId, Date dateOrdered, long noOrdered, Date shippedDate);

    @Modifying
    @Query(value = "INSERT INTO order_line_items (line_id, item_id, order_id, quantity) VALUES (:line_id, :item_id, :order_id, :quantity)", nativeQuery = true)
    @Transactional
    void insertOrderLineItem(@Param("order_id") long custOrderId,@Param("item_id") long itemId,@Param("line_id") long line_id, @Param("quantity") long noOrdered);

    @Modifying
    @Query(value="UPDATE store_items SET number_of_copies=:noOfCopies WHERE item_id=:itemId", nativeQuery = true)
    @Transactional
    void updateNumberOfCopies(@Param("noOfCopies") long noOfCopies, @Param("itemId") long itemId);

    @Query(value="SELECT computeTotal(:orderId) FROM DUAL", nativeQuery = true)
    float computeTotal(@Param("orderId") float orderId);

    @Query(value = "SELECT cust_type FROM customer WHERE cust_id=:custId", nativeQuery = true)
    String findCustomerType(@Param("custId") long custId);

}
