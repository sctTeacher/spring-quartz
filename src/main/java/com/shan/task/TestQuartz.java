package com.shan.task;


import com.shan.config.scheduler.QuartzScheduled;
import com.shan.constant.QuartzCronUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@DisallowConcurrentExecution
@QuartzScheduled(name = "TestQuartz", group = "group1", cron = QuartzCronUtils.QUARTZ_CRON_TEN_SECOND)
public class TestQuartz extends QuartzJobBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void executeInternal(JobExecutionContext context) {
        try {
            Date date =new Date();
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println("TestQuartz执行时间"+sf.format(date));
        } catch (Exception e) {
            logger.info(this.getClass() + "执行异常------------------------>");
            e.printStackTrace();
        }
    }
}
