package com.bobo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobo.entity.Article;
import com.bobo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);


}
