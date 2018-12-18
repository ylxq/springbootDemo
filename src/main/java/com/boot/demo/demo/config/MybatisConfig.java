package com.boot.demo.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan(value = {"com.boot.demo.demo.domain.mapper"}
        , sqlSessionFactoryRef = "sqlSessionFactory"
        , sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybatisConfig {
    @Autowired
    @Qualifier("h2SecondaryDataSource")
    private DataSource h2SecondaryDataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(h2SecondaryDataSource);
        return bean.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
