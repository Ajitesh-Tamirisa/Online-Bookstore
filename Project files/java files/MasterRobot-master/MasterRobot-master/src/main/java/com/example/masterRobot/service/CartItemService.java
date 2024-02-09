package com.example.masterRobot.service;

import com.example.masterRobot.entity.CartItem;
import com.example.masterRobot.entity.store_items;
import com.example.masterRobot.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CartItemRepository cartItemRepository;
//        public List<store_items> list() {
//            return null;
//        }


//    public CartItemService() {
//    }
//
//    public CartItemService(CartItemRepository cartItemRepository) {
//        this.cartItemRepository = cartItemRepository;
//    }

//    @PostConstruct
    public void saveCartItem(CartItem cartItem) {
        System.out.println(cartItem);
        cartItemRepository.save(cartItem);
        System.out.println("sadas");
//        String sql = "INSERT INTO cart_items (item_id,quantity,cust_id) VALUES(?,?,?);";
//
//        List<CartItem> listCartItems = jdbcTemplate.query(sql,
//                BeanPropertyRowMapper.newInstance(CartItem.class));
//        System.out.println("CartItems service "+listCartItems);
    }

    public CartItem get(int id) {
        return null;
    }

    public void update(CartItem cartItem) {
    }

    public void delete(int id) {
    }

    public List<CartItem> list() {
        String sql = "SELECT * FROM cart_items";

        List<CartItem> listCartItems = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CartItem.class));
        System.out.println("CartItems service "+listCartItems);
        return listCartItems;
    }
    public List<CartItem> listByCustId(long cust_id){
        String sql = "SELECT * FROM cart_items WHERE cust_id="+cust_id;

        List<CartItem> listCartItems = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CartItem.class));
        System.out.println("CartItems listByCustId "+listCartItems);
        return listCartItems;
    }

    public double getTotalByCustId(long cust_id){
        String sql = "SELECT SUM(total) FROM cart_items WHERE cust_id="+cust_id;
        System.out.println("In getTotalByCustId, cust id-"+cust_id+"\nSQL - "+sql);
        return jdbcTemplate.queryForObject(sql, Double.class);
    }
}
