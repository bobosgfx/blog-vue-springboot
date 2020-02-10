package com.bobo.vo;

import com.bobo.entity.Category;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVO extends Category implements Serializable {

    private static final long serialVersionUID = -2975739216517528014L;

    private int articles;
}
