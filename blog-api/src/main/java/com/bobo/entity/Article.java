package com.bobo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "me_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public class Article implements Serializable {

    private static final long serialVersionUID = -4470366380115322213L;

    public static final int Article_TOP = 1;
    public static final int Article_Common = 0;

    private int weight = Article_Common; // 置顶

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 40, nullable = false)
    private String title;

    @Column(name = "summary", length = 100, nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "body_id")
    private ArticleBody body;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "me_article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags;

    @OneToMany(mappedBy = "article", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @Column(name = "comment_counts")
    private int commentCounts;

    @Column(name = "view_counts")
    private int viewCounts;

    @JSONField(format = "yyyy.MM.dd HH:mm")
    @Column(name = "create_date")
    private Date createDate;


}
