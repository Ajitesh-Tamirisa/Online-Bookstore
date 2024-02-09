package com.example.masterRobot.service;

import com.example.masterRobot.entity.store_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.masterRobot.repository.storeItemRepository;

import java.util.Date;
import java.util.List;

@Service
public class storeItemsService {

    @Autowired
    storeItemRepository repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public List<store_items> list() {
//            return null;
//        }

        public void save(store_items storeItem) {
        }

        public store_items get(long id) {

            return repo.findById(id).get();
        }

        public void update(store_items storeItem) {
        }

        public void delete(long id) {
        }

        public List<store_items> list() {
        String sql = "SELECT * FROM store_items";

        List<store_items> listItems = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(store_items.class));
        System.out.println("store_items service "+listItems);
        return listItems;
        }

        public long findNumberOfCopies(long item_id){
            String sql = "SELECT number_of_copies FROM store_items WHERE item_id="+item_id;

            long numberOfCopies = jdbcTemplate.queryForObject(sql, Long.class);
            System.out.println("numberOfCopies-  "+numberOfCopies);
            return numberOfCopies;
        }

        public long createCustomerOrder(){
            return repo.createCustOrder();
        }

        public void createOrderLineItem(long orderId, long itemId, long custId, Date dateOrdered, long noOrdered, Date shippedDate, long noOfCopies){
//            repo.createOrderLineItem(orderId, itemId, custId, dateOrdered, noOrdered, shippedDate);
//            String sql = "INSERT INTO order_line_items(line_id, item_id, order_id, quantity"+item_id;
//
//            long numberOfCopies = jdbcTemplate.queryForObject(sql, Long.class);
//            System.out.println("numberOfCopies-  "+numberOfCopies);
//            return numberOfCopies;
        }

        public void insertOrderLineItem(long custOrderId, long itemId, long line_id, long noOrdered){
            System.out.println("In insertOrderLineItem");
            repo.insertOrderLineItem(custOrderId, itemId, line_id, noOrdered);
            System.out.println("completed insertOrderLineItem");
//            repo.updateNoOfCopies(updatedNoOfCopies, itemId);
//            System.out.println("completed updateNoOfCopies");
        }

        public void setShippingDate(long orderId, Date shippedDate){
            repo.setShippingDate(orderId, shippedDate);
        }

        public String findCustomerType(long cust_id){
            return repo.findCustomerType(cust_id);
        }

        public float computeTotal(long order_id){
            return repo.computeTotal(order_id);
        }

        public void updateNumberOfCopies(long updatedNoOfCopies, long item_id){
            repo.updateNumberOfCopies(updatedNoOfCopies, item_id);
        }


}
