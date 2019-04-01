package com.denachina.springmybaitsshardingdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.rule.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Configuration
@MapperScan(basePackages = {"com.denachina.springmybaitsshardingdemo.dao"}, sqlSessionTemplateRef = "shardingSqlSessionTemplate")
public class ShardingConfig {

    @Bean("mutiDataSources")
    public DataSource mutiDataSources() throws SQLException {

        // 配置主库
        HikariDataSource masterDataSource = new HikariDataSource();
        masterDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        masterDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dena_store_cn");
        masterDataSource.setUsername("root");
        masterDataSource.setPassword("root");


        // 配置第一个从库
        HikariDataSource slaveDataSource1 = new HikariDataSource();
        slaveDataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        slaveDataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/lcm_admin");
        slaveDataSource1.setUsername("root");
        slaveDataSource1.setPassword("root");


        // 配置第二个从库
        HikariDataSource slaveDataSource2 = new HikariDataSource();
        slaveDataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        slaveDataSource2.setJdbcUrl("jdbc:mysql://localhost:3306/g_pickle");
        slaveDataSource2.setUsername("root");
        slaveDataSource2.setPassword("root");

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds_master", masterDataSource);
        dataSourceMap.put("ds_slave1", slaveDataSource1);
        dataSourceMap.put("ds_slave2", slaveDataSource2);

        // 配置读写分离规则
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName("ds_master_slave");
        masterSlaveRuleConfig.setMasterDataSourceName("ds_master");
        masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("ds_slave1", "ds_slave2"));

        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new LinkedHashMap<String, Object>(), new Properties());
    }

    
    @Bean
    public SqlSessionFactory shardingSqlSessionFactory(@Qualifier("mutiDataSources") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate shardingSqlSessionTemplate(@Qualifier("shardingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

/*    // 创建两个数据源，一个是ds_jdbc_0，一个是ds_jdbc_1，并绑定映射关系key
    private static Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>(3);
        result.put("ds_master", createDataSource("dena_store_cn"));
        result.put("ds_slave1", createDataSource("dena_store_cn"));
        result.put("ds_slave2", createDataSource("dena_store_cn"));
        return result;
    }

    // 以dbcp组件创建一个数据源
    private static DataSource createDataSource(final String dataSourceName) {
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName("com.mysql.cj.jdbc.Driver");
        result.setJdbcUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
        result.setUsername("root");
        // sharding-jdbc默认以密码为空的root用户访问，如果修改了root用户的密码，这里修改为真实的密码即可；
        result.setPassword("root");
        return result;
    }*/

}
