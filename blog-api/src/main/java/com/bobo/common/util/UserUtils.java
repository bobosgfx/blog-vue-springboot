package com.bobo.common.util;

import com.bobo.common.constant.Base;
import org.apache.shiro.SecurityUtils;

import com.bobo.entity.User;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public class UserUtils {

    public static User getCurrentUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}
