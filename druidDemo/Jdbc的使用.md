# Spring-Jdbc
- core,JdbcTemplate等相关核心接口和类
- datasource，数据源相关的辅助类
- object，将基本的Jdbc操作封装成类
- support，错误码等其它辅助工具

# 常用的Bean注解
- @Component
- @Repository
- @Service
- @Controller
    - @RestController

# JdbcTemplate
- query
- queryForObject
- queryForList
- update
- execute

# SQL批处理
**JdbcTemplate**
- batchUpdate
    - BatchPreparedStatementSetter

**NamedParameterJdbcTemplate**
- batchUpdate
    -SqlParameterSourceUtils.createBatch
