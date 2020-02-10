package com.bobo.vo;

import com.bobo.entity.Tag;
import lombok.*;

import java.io.Serializable;

@Data
public class TagVO extends Tag implements Serializable {

    private static final long serialVersionUID = 5059212992497947120L;

    private int articles;

}
