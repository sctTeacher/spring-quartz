//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.dataSource.context;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

public class DruidDataSourceManager {
    public DruidDataSourceManager() {
    }

    public static void initDataSource(DataSource dataSource, Map map) {
        if (dataSource instanceof DruidDataSource) {
            name((DruidDataSource)dataSource, map);
        }

    }

    private static void name(DruidDataSource ds, Map map) {
        if (map.get("url") != null) {
            ds.setUrl(map.get("url").toString());
        }

        if (map.get("username") != null) {
            ds.setUsername(map.get("username").toString());
        }

        if (map.get("password") != null) {
            ds.setPassword(map.get("password").toString());
        }

        if (map.get("testWhileIdle") != null) {
            ds.setTestWhileIdle(Boolean.parseBoolean(map.get("testWhileIdle").toString()));
        }

        if (map.get("testOnBorrow") != null) {
            ds.setTestOnBorrow(Boolean.parseBoolean(map.get("testOnBorrow").toString()));
        }

        if (map.get("validationQuery") != null) {
            ds.setValidationQuery(map.get("validationQuery").toString());
        }

        if (map.get("useGlobalDataSourceStat") != null) {
            ds.setUseGlobalDataSourceStat(Boolean.parseBoolean(map.get("useGlobalDataSourceStat").toString()));
        }

        if (map.get("filters") != null) {
            try {
                ds.setFilters(map.get("filters").toString());
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        }

        if (map.get("timeBetweenLogStatsMillis") != null) {
            ds.setTimeBetweenLogStatsMillis(Long.parseLong(map.get("timeBetweenLogStatsMillis").toString()));
        }

        if (map.get("maxSize") != null) {
        }

        if (map.get("clearFiltersEnable") != null) {
            ds.setClearFiltersEnable(Boolean.parseBoolean(map.get("clearFiltersEnable").toString()));
        }

        if (map.get("resetStatEnable") != null) {
            ds.setResetStatEnable(Boolean.parseBoolean(map.get("resetStatEnable").toString()));
        }

        if (map.get("notFullTimeoutRetryCount") != null) {
            ds.setNotFullTimeoutRetryCount(Integer.parseInt(map.get("notFullTimeoutRetryCount").toString()));
        }

        if (map.get("maxWaitThreadCount") != null) {
            ds.setMaxWaitThreadCount(Integer.parseInt(map.get("maxWaitThreadCount").toString()));
        }

        if (map.get("failFast") != null) {
            ds.setFailFast(Boolean.parseBoolean(map.get("failFast").toString()));
        }

        if (map.get("phyTimeoutMillis") != null) {
            ds.setPhyTimeoutMillis(Long.parseLong(map.get("phyTimeoutMillis").toString()));
        }

        if (map.get("minEvictableIdleTimeMillis") != null) {
            ds.setMinEvictableIdleTimeMillis(Long.parseLong(map.get("minEvictableIdleTimeMillis").toString()));
        }

        if (map.get("maxEvictableIdleTimeMillis") != null) {
            ds.setMaxEvictableIdleTimeMillis(Long.parseLong(map.get("maxEvictableIdleTimeMillis").toString()));
        }

        if (map.get("initialSize") != null) {
            ds.setInitialSize(Integer.parseInt(map.get("initialSize").toString()));
        }

        if (map.get("minIdle") != null) {
            ds.setMinIdle(Integer.parseInt(map.get("minIdle").toString()));
        }

        if (map.get("maxActive") != null) {
            ds.setMaxActive(Integer.parseInt(map.get("maxActive").toString()));
        }

        if (map.get("maxWait") != null) {
            ds.setMaxWait((long)Integer.parseInt(map.get("maxWait").toString()));
        }

        if (map.get("timeBetweenEvictionRunsMillis") != null) {
            ds.setTimeBetweenEvictionRunsMillis(Long.parseLong(map.get("timeBetweenEvictionRunsMillis").toString()));
        }

        if (map.get("poolPreparedStatements") != null) {
            ds.setPoolPreparedStatements(Boolean.parseBoolean(map.get("poolPreparedStatements").toString()));
        }

        if (map.get("maxPoolPreparedStatementPerConnectionSize") != null) {
            ds.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(map.get("maxPoolPreparedStatementPerConnectionSize").toString()));
        }

        if (map.get("connectionProperties") != null) {
            ds.setConnectionProperties(map.get("connectionProperties").toString());
        }

    }
}
