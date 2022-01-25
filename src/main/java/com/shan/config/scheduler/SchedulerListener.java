//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.config.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SchedulerListener implements JobListener {
    public static final String LISTENER_NAME = "QuartSchedulerListener";

    public SchedulerListener() {
    }

    public String getName() {
        return "QuartSchedulerListener";
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed");
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job : " + jobName + " is going to start...");
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("jobWasExecuted");
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is finished...");
        if (jobException != null && !jobException.getMessage().equals("")) {
            System.out.println("Exception thrown by: " + jobName + " Exception: " + jobException.getMessage());
        }

    }
}
