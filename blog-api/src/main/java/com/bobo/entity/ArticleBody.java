package com.bobo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import java.io.Serializable;


@Entity
@Table(name = "me_article_body")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBody implements Serializable {

    private static final long serialVersionUID = -7611409995977927628L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String content; // 内容

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String contentHtml;
}
