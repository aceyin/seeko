package seeko.repo;

import seeko.common.bean.Repository;

/**
 * Created by aceyin on 13-11-30.
 */
public interface RepositoryManager {

    /**
     * Checkout the remote repository to local disk, this method will be called the first time this repository is created.
     */
    void checkout(Repository repository);

    /**
     * Update remote repository to get the changes to local disk.
     */
    void update(Repository repository);
}
