package seeko.indexer.scheduler;

import javax.annotation.PostConstruct;

/**
 * Created by aceyin on 13-12-1.
 */
public interface IndexerScheduler {

    @PostConstruct
    void init();

    void start(SchedulerContext context);

    void stop(SchedulerContext context);
}
