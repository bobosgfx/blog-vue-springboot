package com.bobo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "me_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 5025313969040054182L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoryname", nullable = false)
    private String categoryname;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "avatar", nullable = false)
    private String avatar;


}
