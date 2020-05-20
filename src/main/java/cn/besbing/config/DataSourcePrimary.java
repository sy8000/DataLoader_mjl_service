package cn.besbing.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * 主数据源
 *
 */
@Configuration
@MapperScan(basePackages = "cn.besbing.mapper.primary",sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class DataSourcePrimary {

    @Autowired
    private Environment env;


    @Bean(name = "primaryDataSource")
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dataSource(){
        //return DataSourceBuilder.create().build();
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.one.driver"))
                .url(env.getProperty("spring.datasource.one.url"))
                .username(env.getProperty("spring.datasource.one.username"))
                .password(env.getProperty("spring.datasource.one.password"))
                .build();
    }


    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/primary/*.xml"));
        //手动加载mybatis全局配置文件
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis-config.xml"));
        return bean.getObject();
    }

    /**
     * 事务管理器
     */

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * sql模板
     */

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     *
     */
    @Bean("primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
