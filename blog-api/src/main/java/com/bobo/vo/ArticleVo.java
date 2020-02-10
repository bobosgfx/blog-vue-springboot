package com.bobo.vo;

import com.bobo.entity.Article;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleVo extends Article implements Serializable {

    private static final long serialVersionUID = -4452157863535302016L;

    private Integer year;

    private Integer month;

    private Integer tagId;

    private Integer categoryId;

    private Integer count;

}
