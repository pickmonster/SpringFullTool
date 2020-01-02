package com.codertoy.druidDemo;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: WuNan
 * @version:2020/1/2
 * @Copyright(C): 2019 by CoderToy
 */
@Data
@Builder // 提供Foo的构造方法
public class Foo {
    private Long id;
    private String bar;
}
