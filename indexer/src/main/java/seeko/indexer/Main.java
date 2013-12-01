package seeko.indexer;

import seeko.indexer.scheduler.impl.RepositoryCheckoutScheduler;
import seeko.indexer.scheduler.impl.RepositoryUpdateScheduler;

/**
 * Created by aceyin on 13-11-30.
 * This is the main class of indexer module response for start the index module.
 */
public class Main {
    public static void main(String... args) {
        new RepositoryCheckoutScheduler().start(null);
        new RepositoryUpdateScheduler().start(null);

        Runtime.getRuntime().addShutdownHook(new Thread("Indexer-Shutdown-Hooker-Thread") {
            @Override
            public void run() {
                throw new RuntimeException("not implement yet");
            }
        });
    }
}
