package com.bobo.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {

    private static final long serialVersionUID = 1551383038621218642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "module", length = 10)
    private String module;

    @Column(name = "operation", length = 25)
    private String operation;

    @Column(name = "method", length = 100)
    private String method;

    @Column(name = "params")
    private String params;

    @Column(name = "time")
    private Long time;

    @Column(name = "ip", length = 15)
    private String ip;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;
}
