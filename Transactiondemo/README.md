# 一致的事务模型
- JDBC/Hibernate/myBatis
- DataSource/JTA

# 事务抽象的核心接口
- PlatforTransactionManager
    - DataSourceTransactionManager
    - HibernateTransactionManager
    - JtaTransactionManager
- TransactionDefinition
    - Propagation
    - Isolation
    - Timeout
    - Read-only status
- 示例
    - void commit(TransactionStatus status) throws TransactionException;
    - rollback(TransactionStatus status) throws TransactionException;
    - TransactionStatus getTransaction(@Nullable TransactionDefinition definition) throws TransactionException;

# 事务的传播特性（7种）
- PROPAGATION_REQUIRED：0：当前有事务就用当前的，没有就用新的（默认）
- PROPAGATION_SUPPORTS：1：事务可有可无，不是必须的
- PROPAGATION_MANDATORY：2：当前一定要有事务，不然就抛异常
- PROPAGATION_REQUIRES_NEW：3：无论是否有事务，都起一个新的事务
- PROPAGATION_NOT_SUPPORTED：4：不支持事务，按非事务运行
- PROPAGATION_NEVER：5：不支持事务，如果有事务则抛异常
- PROPAGATION_NESTED：6：当前有事务就在当前事务里再起一个事务

# 事务隔离特性
- ISOLATION_READ_UNCOMMITTED：1：脏读、可重复读、幻读
- ISOLATION_READ_COMMITTED：2：可重复读、幻读
- ISOLATION_REPEATABLE_READ：3：幻读
- ISOLATION_SERIALIZABLE：4

# 编程式事务
- TransactionTemplate
    - TransactionCallback
    - TransactionCallbackWithoutResult
- PlatformTransactionManager
    - 可以传入TransactionDefinition进行定义

# 基于注解的配置方式
### 开启事务注解的方式
- @EnableTransactionManagement
- <tx:annotation-driven />
### 一些配置
- proxyTargetClass：AOP是基于接口还是基于类的，true/false
- mode
- order：事务的优先级，默认是最低的优先级
### @Transactional
- TransactionManager
- propagation
- isolation
- timeout
- readOnly
- 怎么判断回滚