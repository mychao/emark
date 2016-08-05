package com.mychao.emark.repository;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author myc
 * @version 2016/8/3
 */
@Configuration
@MapperScan(value = "com.mychao.emark.repository.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class EmarkDatasource {
    private DruidDataSource druidDataSource;

    @Value("classpath:mybatis/emark/*.xml")
    private Resource[] mapperLocations;

    @Value("com.mychao.emark.entity")
    private String typeAliasesPackage;

    @Primary
    @Bean(initMethod = "init", destroyMethod = "close", name = "dataSource")
    @Autowired
    protected DruidDataSource druidDataSource(@Value("${ds.emark.jdbc.url}") String url,
                                              @Value("${ds.emark.jdbc.username}") String userName,
                                              @Value("${ds.emark.jdbc.password}") String password,
                                              @Value("${ds.emark.jdbc.maxActive}") int maxActive,
                                              @Value("${ds.emark.jdbc.maxWait}") int maxWait,
                                              @Value("${ds.emark.jdbc.initialSize}") int initialSize,
                                              @Value("${ds.emark.jdbc.minIdle}") int minIdle,
                                              @Value("${ds.emark.jdbc.slowSqlMillis}") int slowSqlMillis,
                                              @Value("${ds.emark.jdbc.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis,
                                              @Value("${ds.emark.jdbc.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis,
                                              @Value("${ds.emark.jdbc.validationQuery}") String validationQuery,
                                              @Value("${ds.emark.jdbc.testWhileIdle}") boolean testWhileIdle,
                                              @Value("${ds.emark.jdbc.testOnBorrow}") boolean testOnBorrow,
                                              @Value("${ds.emark.jdbc.testOnReturn}") boolean testOnReturn,
                                              @Value("${ds.emark.jdbc.poolPreparedStatements}") boolean poolPreparedStatements,
                                              @Value("${ds.emark.jdbc.maxPoolPreparedStatementPerConnectionSize}") int maxPoolPreparedStatementPerConnectionSize) {
        druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(
                maxPoolPreparedStatementPerConnectionSize);
        return druidDataSource;
    }

    @Bean(autowire = Autowire.BY_NAME)
    protected TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        return transactionTemplate;
    }

    @Bean(autowire = Autowire.BY_NAME, name = "transactionManager")
    protected DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource);
    }

    @Bean(autowire = Autowire.BY_NAME, name = "sqlSessionFactory")
    protected SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean;
    }
}
