package com.bobo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "me_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    public static final int Article_TOP = 1;
    public static final int Article_Common = 0;

    private static final long serialVersionUID = -4470366380115322213L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 40, nullable = false)
    private String title;

    @Column(name = "summary", length = 100, nullable = false)
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "body_id")
    private ArticleBody body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "me_article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article", orphanRemoval = true)
    private List<Comment> comments;

    @Column(name = "comment_counts")
    private int commentCounts;

    @Column(name = "view_counts")
    private int viewCounts;

    /**
     * 置顶
     */
    private int weight = Article_Common;


    /**
     * 创建时间
     */
    @JSONField(format = "yyyy.MM.dd HH:mm")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


}
