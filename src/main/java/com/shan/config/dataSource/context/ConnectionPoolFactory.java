//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.dataSource.context;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.base.Optional;
import com.shan.utils.BeanTransferUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.Map;

public class ConnectionPoolFactory {
    public ConnectionPoolFactory() {
    }

    public static Optional<DataSource> create(String className, Map config) {
        Optional<DataSource> result = Optional.absent();
        if (className.indexOf("DruidDataSource") > 0) {
            result = Optional.fromNullable(DruidDataSourceBuilder.create().build());
            DruidDataSourceManager.initDataSource((DataSource)result.get(), config);
        } else if (className.indexOf("HikariDataSource") > 0) {
            HikariConfig hikariConfig = new HikariConfig();
            HikariDataSourceProperties properties = (new HikariDataSourceProperties()).initFromConfig(config);
            BeanTransferUtils.bean2bean(properties, hikariConfig);
            result = Optional.fromNullable(new HikariDataSource(hikariConfig));
        } else if (className.indexOf("DruidXADataSource") > 0) {
            DruidXADataSource xaDataSource = new DruidXADataSource();

            try {
                result = Optional.fromNullable(xaDataSource);
                DruidDataSourceManager.initDataSource((DataSource)result.get(), config);
            } catch (Throwable var8) {
                try {
                    xaDataSource.close();
                } catch (Throwable var6) {
                    var8.addSuppressed(var6);
                }

                throw var8;
            }

            xaDataSource.close();
        } else {
            try {
                Class type = Class.forName(className);
                result = Optional.fromNullable(DataSourceBuilder.create().type(type).build());
            } catch (ClassNotFoundException var7) {
                throw new IllegalStateException(var7);
            }
        }

        return result;
    }
}
