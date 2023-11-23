package com.example.demo.Controller;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SE {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myjob","group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("mytrigger","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */70 * ? *"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }
}
