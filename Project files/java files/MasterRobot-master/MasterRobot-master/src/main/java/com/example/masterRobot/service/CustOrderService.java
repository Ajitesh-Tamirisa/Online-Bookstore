package com.example.masterRobot.service;

import com.example.masterRobot.entity.CustOrder;
import com.example.masterRobot.entity.store_items;
import com.example.masterRobot.repository.CustOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustOrderRepo repo;

//        public List<store_items> list() {
//            return null;
//        }

    public void save(CustOrder custOrder) {
        repo.save(custOrder);
    }

    public CustOrder get(long id) {
        return null;
    }

    public void update(CustOrder custOrder) {
    }

    public void delete(long id) {
    }

    public List<CustOrder> listOrders() {
        String sql = "SELECT * FROM cust_order";

        List<CustOrder> listOrders = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CustOrder.class));
        return listOrders;
    }
}
