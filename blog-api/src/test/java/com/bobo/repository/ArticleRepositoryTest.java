package com.bobo.repository;

import com.bobo.BlogApiApplicationTests;
import com.bobo.entity.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description: com.bobo.repository
 * Author: bo_yu
 * Date: 2020/4/3
 */
public class ArticleRepositoryTest extends BlogApiApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findByTags() {
    }

    @Test
    public void findByCategory() {
    }

    @Test
    public void findOrderByViewsAndLimit() {
        List<Article> orderByViewsAndLimit = articleRepository.findOrderByViewsAndLimit(6);
        System.out.println(orderByViewsAndLimit);
    }

    @Test
    public void findOrderByCreateDateAndLimit() {
    }
}
