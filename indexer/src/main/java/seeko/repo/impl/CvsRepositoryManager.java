package seeko.repo.impl;

import seeko.common.bean.Repository;
import seeko.repo.RepositoryManager;

/**
 * Created by aceyin on 13-12-1.
 */
public class CvsRepositoryManager implements RepositoryManager {
    @Override
    public void checkout(Repository repository) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public void update(Repository repository) {
        throw new RuntimeException("not implemented yet");
    }
}
