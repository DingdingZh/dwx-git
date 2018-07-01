package com.jsc.stationinfoweb.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
import java.util.Properties;

@Configuration
@MapperScan(basePackages ={ "com.jsc.stationinfoweb.dao"},sqlSessionFactoryRef = "defaultSqlSessionFactory")
public class DefaultDataSourceConfig {

    @Bean(name = "defaultDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource defaultDataSource(){return DataSourceBuilder.create().build();}

    @Bean(name = "defaultTransactionManager")
    @Primary
    public DataSourceTransactionManager defaultTransactionManager(@Qualifier("defaultDataSource") DataSource defaultDataSource){
        return new DataSourceTransactionManager(defaultDataSource);
    }

    @Bean(name = "defaultSqlSessionFactory")
    @Primary
    public SqlSessionFactory defaultSqlSessionFactory(@Qualifier("defaultDataSource") DataSource defaultDataSource) throws Exception{
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(defaultDataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.jsc.stationweb.datamodel");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapping/*.xml"));

        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        sessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        return  sessionFactoryBean.getObject();
    }
}
