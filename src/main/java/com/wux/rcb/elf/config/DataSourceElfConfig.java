package com.wux.rcb.elf.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Primary
@MapperScan(basePackages = "com.wux.rcb.elf.biz.dao.elf", sqlSessionTemplateRef = "elfSqlSessionTemplate")
public class DataSourceElfConfig {

    @Bean(name = "elfDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.elf")
    @Primary
    public DataSource elfDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "elfSqlSessionFactory")
    @Primary
    public SqlSessionFactory elfSqlSessionFactory(@Qualifier("elfDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/elf/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "elfTransactionManager")
    @Primary
    public DataSourceTransactionManager elfTransactionManager(@Qualifier("elfDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "elfSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate elfSqlSessionTemplate(@Qualifier("elfSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
