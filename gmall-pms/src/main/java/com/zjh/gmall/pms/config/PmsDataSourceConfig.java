package com.zjh.gmall.pms.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 24923 on 2019/12/21 14:43
 */
//这是一个配置类
@Configuration
public class PmsDataSourceConfig {
    @Bean
    public DataSource dataSource() throws IOException, SQLException {

        File file = ResourceUtils.getFile("classpath:sharding-jdbc.yml");
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(file);

        return dataSource;
    }
}
