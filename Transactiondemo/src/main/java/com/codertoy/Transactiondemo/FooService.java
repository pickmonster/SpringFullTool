package com.codertoy.Transactiondemo;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: WuNan
 * @version:2020/1/3
 * @Copyright(C): 2019 by 北京基于未来教育科技有限公司
 */
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
}
