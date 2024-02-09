package com.example.masterRobot.service;

import com.example.masterRobot.entity.ComicBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComicBooksService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public List<store_items> list() {
//            return null;
//        }

    public void save(ComicBooks comicBooks) {
    }

    public ComicBooks get(long id) {
        return null;
    }

    public void update(ComicBooks comicBooks) {
    }

    public void delete(long id) {
    }

    public List<ComicBooks> listBooks() {
        String sql = "SELECT * FROM comic_books";

        List<ComicBooks> listComicBooks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(ComicBooks.class));
        System.out.println(listComicBooks);
        return listComicBooks;
    }
}
