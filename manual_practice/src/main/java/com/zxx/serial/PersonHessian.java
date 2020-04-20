package com.zxx.serial;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2020/04/20
 */
@Data
public class PersonHessian implements Serializable {
    private Long id;
    private String name;
    private Boolean male;
}
