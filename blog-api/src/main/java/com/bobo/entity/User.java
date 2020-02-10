package com.bobo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4454737765850239378L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account", unique = true, length = 10, nullable = false)
    private String account;

    @Column(name = "password", length = 64, nullable = false)
    private String password; // 使用md5(username + original password + salt)加密存储

    @Column(name = "avatar")
    private String avatar; // 头像

    @Column(name = "email", unique = true, length = 20)
    private String email;

    @Column(name = "nickname", length = 10, nullable = false)
    private String nickname;

    @Column(name = "mobile_phone_number", length = 20)
    private String mobilePhoneNumber;

    @Column(name = "salt")
    private String salt;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.normal; // 系统登陆状态

    @Column(name = "admin")
    private Boolean admin = false; // 是否为管理员

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE; // 逻辑删除flag
}
