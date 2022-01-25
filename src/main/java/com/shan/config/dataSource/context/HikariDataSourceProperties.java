//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.dataSource.context;

import com.google.common.base.Optional;
import org.apache.commons.collections4.MapUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class HikariDataSourceProperties {
    private String username;
    private String password;
    private String jdbcUrl;
    private String driverClassName;
    private Integer maximumPoolSize;
    private String connectionTestQuery;
    private String poolName;
    private Properties dataSourceProperties = new Properties();

    public HikariDataSourceProperties initFromConfig(Map map) {
        if (MapUtils.isEmpty(map)) {
            return this;
        } else {
            if (map.get("url") != null) {
                this.setJdbcUrl(map.get("url").toString());
            }

            if (map.get("username") != null) {
                this.setUsername(map.get("username").toString());
            }

            if (map.get("password") != null) {
                this.setPassword(map.get("password").toString());
            }

            if (map.get("driverClassName") != null) {
                this.setDriverClassName(map.get("driverClassName").toString());
            }

            if (map.get("maximumPoolSize") != null) {
                this.setMaximumPoolSize(Integer.parseInt(map.get("maximumPoolSize").toString()));
            }

            if (map.get("connectionTestQuery") != null) {
                this.setConnectionTestQuery(map.get("connectionTestQuery").toString());
            }

            if (map.get("poolName") != null) {
                this.setPoolName(map.get("poolName").toString());
            }

            Optional<Object> hikariConfig = Optional.fromNullable(map.get("hikari"));
            if (!hikariConfig.isPresent()) {
                return this;
            } else {
                Map<String, Object> configItem = (Map)hikariConfig.get();
                Iterator var4 = configItem.entrySet().iterator();

                while(var4.hasNext()) {
                    Entry<String, Object> entry = (Entry)var4.next();
                    this.dataSourceProperties.put(entry.getKey(), entry.getValue());
                }

                return this;
            }
        }
    }

    public HikariDataSourceProperties() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getJdbcUrl() {
        return this.jdbcUrl;
    }

    public String getDriverClassName() {
        return this.driverClassName;
    }

    public Integer getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public String getConnectionTestQuery() {
        return this.connectionTestQuery;
    }

    public String getPoolName() {
        return this.poolName;
    }

    public Properties getDataSourceProperties() {
        return this.dataSourceProperties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public void setDataSourceProperties(Properties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HikariDataSourceProperties)) {
            return false;
        } else {
            HikariDataSourceProperties other = (HikariDataSourceProperties)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$maximumPoolSize = this.getMaximumPoolSize();
                    Object other$maximumPoolSize = other.getMaximumPoolSize();
                    if (this$maximumPoolSize == null) {
                        if (other$maximumPoolSize == null) {
                            break label107;
                        }
                    } else if (this$maximumPoolSize.equals(other$maximumPoolSize)) {
                        break label107;
                    }

                    return false;
                }

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                label86: {
                    Object this$jdbcUrl = this.getJdbcUrl();
                    Object other$jdbcUrl = other.getJdbcUrl();
                    if (this$jdbcUrl == null) {
                        if (other$jdbcUrl == null) {
                            break label86;
                        }
                    } else if (this$jdbcUrl.equals(other$jdbcUrl)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$driverClassName = this.getDriverClassName();
                    Object other$driverClassName = other.getDriverClassName();
                    if (this$driverClassName == null) {
                        if (other$driverClassName == null) {
                            break label79;
                        }
                    } else if (this$driverClassName.equals(other$driverClassName)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$connectionTestQuery = this.getConnectionTestQuery();
                    Object other$connectionTestQuery = other.getConnectionTestQuery();
                    if (this$connectionTestQuery == null) {
                        if (other$connectionTestQuery == null) {
                            break label72;
                        }
                    } else if (this$connectionTestQuery.equals(other$connectionTestQuery)) {
                        break label72;
                    }

                    return false;
                }

                Object this$poolName = this.getPoolName();
                Object other$poolName = other.getPoolName();
                if (this$poolName == null) {
                    if (other$poolName != null) {
                        return false;
                    }
                } else if (!this$poolName.equals(other$poolName)) {
                    return false;
                }

                Object this$dataSourceProperties = this.getDataSourceProperties();
                Object other$dataSourceProperties = other.getDataSourceProperties();
                if (this$dataSourceProperties == null) {
                    if (other$dataSourceProperties != null) {
                        return false;
                    }
                } else if (!this$dataSourceProperties.equals(other$dataSourceProperties)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof HikariDataSourceProperties;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $maximumPoolSize = this.getMaximumPoolSize();
         result = result * 59 + ($maximumPoolSize == null ? 43 : $maximumPoolSize.hashCode());
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $jdbcUrl = this.getJdbcUrl();
        result = result * 59 + ($jdbcUrl == null ? 43 : $jdbcUrl.hashCode());
        Object $driverClassName = this.getDriverClassName();
        result = result * 59 + ($driverClassName == null ? 43 : $driverClassName.hashCode());
        Object $connectionTestQuery = this.getConnectionTestQuery();
        result = result * 59 + ($connectionTestQuery == null ? 43 : $connectionTestQuery.hashCode());
        Object $poolName = this.getPoolName();
        result = result * 59 + ($poolName == null ? 43 : $poolName.hashCode());
        Object $dataSourceProperties = this.getDataSourceProperties();
        result = result * 59 + ($dataSourceProperties == null ? 43 : $dataSourceProperties.hashCode());
        return result;
    }

    public String toString() {
        return "HikariDataSourceProperties(username=" + this.getUsername() + ", password=" + this.getPassword() + ", jdbcUrl=" + this.getJdbcUrl() + ", driverClassName=" + this.getDriverClassName() + ", maximumPoolSize=" + this.getMaximumPoolSize() + ", connectionTestQuery=" + this.getConnectionTestQuery() + ", poolName=" + this.getPoolName() + ", dataSourceProperties=" + this.getDataSourceProperties() + ")";
    }
}
