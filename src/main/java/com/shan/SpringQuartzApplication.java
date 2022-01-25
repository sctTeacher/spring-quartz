package com.shan;

import com.shan.config.scheduler.SchedulerManager;
import com.shan.utils.SpringContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class SpringQuartzApplication  implements CommandLineRunner {

    private final ApplicationContext appContext;

    public final SchedulerManager myScheduler;

    public SpringQuartzApplication(ApplicationContext appContext, SchedulerManager myScheduler) {
        this.appContext = appContext;
        this.myScheduler = myScheduler;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run =  SpringApplication.run(SpringQuartzApplication.class, args);
        SpringContextUtils.setApplicationContext(run);
    }

    @Override
    public void run(String... args) {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
        // 加载所有任务类（如果有新增任务类，需要在部署前先清空所有QUARTZ开头的表）
        myScheduler.initAllJob(appContext);
    }


}
