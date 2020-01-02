package com.codertoy.druidDemo;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: WuNan
 * @version:2020/1/2
 * @Copyright(C): 2019 by 北京基于未来教育科技有限公司
 */
@Data
@Builder // 提供Foo的构造方法
public class Foo {
    private Long id;
    private String bar;
}
