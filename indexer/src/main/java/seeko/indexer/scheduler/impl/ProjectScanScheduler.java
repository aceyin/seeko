package seeko.indexer.scheduler.impl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
import seeko.indexer.job.ProjectScannerJob;
import seeko.indexer.scheduler.IndexerScheduler;
import seeko.indexer.scheduler.SchedulerContext;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by aceyin on 13-12-2.
 */
@Component
public class ProjectScanScheduler implements IndexerScheduler {
    private static final String JOB_NAME = "project-scanner-job";
    private static final String JOB_GROUP = "project-job";
    private static final String TRIGGER_NAME = "project-scanner-job-trigger";
    private static final String TRIGGER_GROUP = "project-job";
    public static final int INTERVAL_IN_MINUTES = 1;
    private Scheduler scheduler;

    @Override
    public void init() {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail detail = newJob(ProjectScannerJob.class).withIdentity(JOB_NAME, JOB_GROUP).build();

            SimpleScheduleBuilder scheduleBuilder = simpleSchedule().withIntervalInMinutes(INTERVAL_IN_MINUTES).repeatForever();

            Trigger trigger = newTrigger().withIdentity(TRIGGER_NAME, TRIGGER_GROUP).startNow().withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(detail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(SchedulerContext context) {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(SchedulerContext context) {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
