package com.bobo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "me_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 7346271954336613146L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    /**
     * 类型 0 文章的评论 1 评论的评论 2 评论的回复 @
     */
    @Column(name = "level",length = 1)
    private String level;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy.MM.dd HH:mm")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @OneToMany
    @JoinColumn(name = "parent_id",nullable = true)
    private List<Comment> childrens;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private Comment parent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_uid")
    private User toUser;




}
