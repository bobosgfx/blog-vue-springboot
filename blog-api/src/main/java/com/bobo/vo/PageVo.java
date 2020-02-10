package com.bobo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class PageVo implements Serializable {

    private static final long serialVersionUID = 5036413568056427870L;

    private Integer pageNumber;

    private Integer pageSize;

    private String name;

    private String sort;

}
