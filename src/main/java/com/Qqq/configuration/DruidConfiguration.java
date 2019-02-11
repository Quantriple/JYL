package com.Qqq.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2019/1/27.
 */
@Configuration
public class DruidConfiguration  {

    @Bean(name = "dataSource1", initMethod = "init", destroyMethod = "close")
    public DataSource compare1DataSource(
            @Value("${dataSource1.driver-class-name}") String driver,
            @Value("${dataSource1.url}") String url,
            @Value("${dataSource1.username}") String username,
            @Value("${dataSource1.password}") String password,
            @Value("${dataSource1.minIdle}") int minIdle,
            @Value("${dataSource1.max-active}") int maxActive,
            @Value("${dataSource1.initial-size}") int initialSize,
            @Value("${dataSource1.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis,
            @Value("${dataSource1.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis,
            @Value("${dataSource1.validationQuery}") String validationQuery,
            @Value("${dataSource1.testWhileIdle}") boolean testWhileIdle,
            @Value("${dataSource1.testOnBorrow}") boolean testOnBorrow,
            @Value("${dataSource1.testOnReturn}") boolean testOnReturn) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource
                .setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource
                .setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        return druidDataSource;
    }

}
