//package com.example.masterRobot.service;
//
//import com.example.masterRobot.entity.CustOrder;
//import com.example.masterRobot.entity.OrderLineItems;
//import com.example.masterRobot.repository.CustOrderRepo;
//import com.example.masterRobot.repository.OrderLineItemsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class OrderLineItemsService {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private OrderLineItemsRepository repo;
//
//    public void save(OrderLineItems orderLineItems) {
//        repo.save(orderLineItems);
//    }
//
//    public OrderLineItems get(long id) {
//        return null;
//    }
//
//    public void update(OrderLineItems orderLineItems) {
//    }
//
//    public void delete(long id) {
//    }
//}
