package com.shan.task;


import com.shan.config.scheduler.QuartzScheduled;
import com.shan.constant.QuartzCronUtils;
import com.shan.service.TestService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
//验证定时任务中的事务
@Component
@DisallowConcurrentExecution
@QuartzScheduled(name = "TestQuartzTranc", group = "group1", cron = QuartzCronUtils.QUARTZ_CRON_TEN_SECOND)
public class TestQuartzTranc extends QuartzJobBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService  testService;

    @Override
    public void executeInternal(JobExecutionContext context) {
        try {
            Date date =new Date();
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println("TestQuartzTranc执行开始时间"+sf.format(date));
            //testService.testTransactional();
            System.out.println("TestQuartzTranc执行结束时间"+sf.format(date));
        } catch (Exception e) {
            logger.info(this.getClass() + "执行异常------------------------>");
            e.printStackTrace();
        }
    }
}
