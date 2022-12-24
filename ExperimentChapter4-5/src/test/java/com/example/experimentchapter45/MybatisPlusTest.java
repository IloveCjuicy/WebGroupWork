package com.example.experimentchapter45;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest
{
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testSelectList()
    {
//        通过条件查询一个list集合
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }
}
