package com.Qqq.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2019/1/28.
 */
@Configuration
@MapperScan(basePackages = {"com.Qqq.mapper"}, sqlSessionFactoryRef = "SqlSessionFactory")
public class MybitsConfiguration {

    private Logger logger = LoggerFactory.getLogger(MybitsConfiguration.class);

    @Autowired
    @Qualifier(value = "dataSource1")
    private DataSource dataSource;

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Value("${mybatis1.mapper-locations}") String mapperLocations,
                                                   @Value("${mybatis1.type-aliases-package}") String typeAliasesPackage) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        logger.debug(dataSource.getConnection().toString());
        System.out.println(dataSource.toString());
        return sessionFactoryBean;
    }

    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


}
