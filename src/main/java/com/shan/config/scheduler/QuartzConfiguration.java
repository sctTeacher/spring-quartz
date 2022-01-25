package com.shan.config.scheduler;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;

import com.shan.config.dataSource.context.ConnectionPoolFactory;
import org.quartz.Scheduler;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(
    name = {"spring.quartz.jobStoreType"}
)
@Configuration
public class QuartzConfiguration implements EnvironmentAware {
    @Autowired
    private QuartzProperties properties;
    private Map<String, Object> dataSourceConfig = Maps.newHashMap();

    public QuartzConfiguration() {
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

    @Bean(
        name = {"schedulerManager"}
    )
    public SchedulerManager getSchedulerManager(Scheduler scheduler) {
        return new SchedulerManager(scheduler);
    }

    @Bean
    @QuartzDataSource
    public DataSource quartzDataSource() {
        Optional<DataSource> result = ConnectionPoolFactory.create(this.dataSourceConfig.get("type").toString(), this.dataSourceConfig);
        Preconditions.checkState(result.isPresent(), "An exception has occurred to create Quartz datasource.");
        return (DataSource)result.get();
    }

    @Bean(
        name = {"scheduler"}
    )
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
        return scheduler;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(QuartzConfiguration.QuartzJobFactory quartzJobFactory) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(this.quartzDataSource());
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setJobFactory(quartzJobFactory);
        schedulerFactoryBean.setQuartzProperties(this.asProperties(this.properties.getProperties()));
        schedulerFactoryBean.setStartupDelay(15);
        return schedulerFactoryBean;
    }

    public void setEnvironment(Environment environment) {
        this.dataSourceConfig = (Map)Binder.get(environment).bind("spring.datasource.quartz", Bindable.mapOf(String.class, Object.class)).get();
    }

    @Component("quartzJobFactory")
    private class QuartzJobFactory extends SpringBeanJobFactory {
        @Autowired
        private AutowireCapableBeanFactory capableBeanFactory;

        private QuartzJobFactory() {
        }

        protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
            Object jobInstance = super.createJobInstance(bundle);
            this.capableBeanFactory.autowireBean(jobInstance);
            return jobInstance;
        }
    }
}
