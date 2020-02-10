package com.bobo.repository.wrapper;

import com.bobo.entity.Article;
import com.bobo.vo.ArticleVo;
import com.bobo.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
