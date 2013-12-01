package seeko.indexer.scheduler;

/**
 * Created by aceyin on 13-12-1.
 */
public interface RepositoryScheduler {

    void start(SchedulerContext context);

    void stop(SchedulerContext context);
}
