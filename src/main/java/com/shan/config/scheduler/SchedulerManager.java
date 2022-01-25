//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.scheduler;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.shan.bean.QuartzJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.context.ApplicationContext;

public class SchedulerManager {
    private Scheduler scheduler;
    private JobListener scheduleListener;

    public SchedulerManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void addJob(QuartzJob job) {
        try {
            Class<?> clazz = Class.forName(job.getBeanName());
            Job jobEntity = (Job) clazz.newInstance();
            JobDetail jobDetail = JobBuilder.newJob(jobEntity.getClass()).withIdentity(job.getJobName()).build();
            Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(job.getTriggerName()).startNow().withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())).build();
            this.scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (InstantiationException | IllegalAccessException | SchedulerException | ClassNotFoundException var6) {
            var6.printStackTrace();
        }

    }

    public void deleteJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
            this.scheduler.deleteJob(jobKey);
        } catch (SchedulerException var3) {
            var3.printStackTrace();
        }

    }

    private List<Object> getAllJobBean(ApplicationContext context) {
        Map<String, Object> jobs = context.getBeansWithAnnotation(QuartzScheduled.class);
        Iterator<Object> it = jobs.values().iterator();
        ArrayList result = Lists.newArrayList();

        while (it.hasNext()) {
            Object object = it.next();
            if (object instanceof Job) {
                result.add(object);
            }
        }

        return result;
    }

    public void initAllJob(ApplicationContext context) {
        List jobs = getAllJobBean(context);
        for (Iterator localIterator = jobs.iterator(); localIterator.hasNext(); ) {
            Object bean = localIterator.next();
            QuartzScheduled scheduled = (QuartzScheduled) bean.getClass().getAnnotation(QuartzScheduled.class);
            try {
                QuartzJob quartzJob = new QuartzJob().setJobName(scheduled.name()).setJobGroup(scheduled.group())
                        .setBeanName(bean
                                .getClass().getName()).setCronExpression(scheduled.cron());
                startJob(quartzJob);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void initARunAllJobNow(ApplicationContext context, String group) {
        List<Object> jobs = this.getAllJobBean(context);
        Iterator var4 = jobs.iterator();

        while (var4.hasNext()) {
            Object bean = var4.next();
            QuartzScheduled scheduled = (QuartzScheduled) bean.getClass().getAnnotation(QuartzScheduled.class);

            try {
                QuartzJob quartzJob = (new QuartzJob()).setJobName(scheduled.name()).setJobGroup(scheduled.group()).setBeanName(bean.getClass().getName()).setCronExpression(scheduled.cron());
                this.startJob(quartzJob);
                if (quartzJob.getJobGroup().equals(group)) {
                    this.runAJobNow(quartzJob);
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

    }

    public void pauseJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
            this.scheduler.pauseJob(jobKey);
        } catch (SchedulerException var3) {
            var3.printStackTrace();
        }

    }

    public void resumeJob(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
            this.scheduler.resumeJob(jobKey);
        } catch (SchedulerException var3) {
            var3.printStackTrace();
        }

    }

    public void runAJobNow(QuartzJob quartzJob) {
        try {
            JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
            this.scheduler.triggerJob(jobKey);
        } catch (SchedulerException var3) {
            var3.printStackTrace();
        }

    }

    public void startJob(QuartzJob quartzJob) {
        try {
            if (this.scheduleListener == null) {
                this.scheduleListener = new SchedulerListener();
                this.scheduler.getListenerManager().addJobListener(this.scheduleListener);
            }

            JobKey jobKey = new JobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
            if (!this.scheduler.checkExists(jobKey)) {
                Class<?> clazz = Class.forName(quartzJob.getBeanName());
                Job jobEntity = (Job) clazz.newInstance();
                JobDetail jobDetail = JobBuilder.newJob(jobEntity.getClass()).withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup()).build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
                CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup()).withSchedule(scheduleBuilder).build();
                this.scheduler.scheduleJob(jobDetail, cronTrigger);
            }
        } catch (InstantiationException | IllegalAccessException | SchedulerException | ClassNotFoundException var8) {
            var8.printStackTrace();
        }

    }

    public void updateJobCron(QuartzJob quartzJob) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getJobName());
            CronTrigger trigger = (CronTrigger) this.scheduler.getTrigger(triggerKey);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
            trigger = (CronTrigger) trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            this.scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException var5) {
            var5.printStackTrace();
        }

    }
}
