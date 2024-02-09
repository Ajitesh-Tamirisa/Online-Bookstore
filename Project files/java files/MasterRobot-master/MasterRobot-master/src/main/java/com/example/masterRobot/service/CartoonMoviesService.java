package com.example.masterRobot.service;

import com.example.masterRobot.entity.CartoonMovies;
import com.example.masterRobot.entity.store_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonMoviesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public List<store_items> list() {
//            return null;
//        }

    public void save(CartoonMovies cartoonMovies) {
    }

    public CartoonMovies get(long id) {
        return null;
    }

    public void update(CartoonMovies cartoonMovies) {
    }

    public void delete(long id) {
    }

    public List<CartoonMovies> listMovies() {
//        String sql = "SELECT * FROM cartoon_movies";
//
//        List<CartoonMovies> listCartoonMovies = jdbcTemplate.query(sql,
//                BeanPropertyRowMapper.newInstance(CartoonMovies.class));
//        System.out.println("Cartoon movies-"+listCartoonMovies);
//        return listCartoonMovies;

        String sql = "SELECT * FROM cartoon_movies";

        List<CartoonMovies> listCartoonMovies = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CartoonMovies.class));
        System.out.println(listCartoonMovies);
        return listCartoonMovies;
    }
}
