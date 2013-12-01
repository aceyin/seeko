package seeko.indexer;

import seeko.indexer.scheduler.impl.RepositoryCheckoutScheduler;
import seeko.indexer.scheduler.impl.RepositoryUpdateScheduler;

/**
 * Created by aceyin on 13-11-30.
 * This is the main class of indexer module response for start the index module.
 * The main responsibilities of this class are:
 * 1. startup the indexer node
 * 2. startup the schedulers
 * 3. add shutdown hook to stop the schedulers
 */
public class Main {
    public static void main(String... args) {
        final RepositoryCheckoutScheduler checkoutScheduler = new RepositoryCheckoutScheduler();
        checkoutScheduler.start(null);

        final RepositoryUpdateScheduler updateScheduler = new RepositoryUpdateScheduler();
        updateScheduler.start(null);

        Runtime.getRuntime().addShutdownHook(new Thread("Indexer-Shutdown-Hooker-Thread") {
            @Override
            public void run() {
                checkoutScheduler.stop(null);
                updateScheduler.stop(null);
            }
        });
    }
}
