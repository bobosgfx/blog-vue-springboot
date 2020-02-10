package com.bobo.common.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义异常
 */
@Data
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 3506744187536228284L;

    private String errCode;
    private String errMsg;

}
