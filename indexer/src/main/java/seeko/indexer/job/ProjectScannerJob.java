package seeko.indexer.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seeko.common.Env;
import seeko.common.bean.Project;
import seeko.common.bean.Projects;

import java.io.File;
import java.util.List;

/**
 * Created by aceyin on 13-12-2.
 * The job for scan the project configuration file to load the projects configured by user.
 */
public class ProjectScannerJob implements Job {
    private Logger LOGGER = LoggerFactory.getLogger(ProjectScannerJob.class);

    private static final File PROJECT_FILE = new File(Env.SEEKO_HOME.val() + File.separator + "projects.xml");
    private static final File PROJECT_HOME = new File(Env.SEEKO_DATA_DIR.val() + File.separator + "projects");
    private long lastModify = 0L;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.debug("Start ProjectScannerJob >>>");
        long l = PROJECT_FILE.lastModified();
        if (l > lastModify) {
            lastModify = l;
            List<Project> projects = Projects.load(PROJECT_FILE);
        }
        LOGGER.debug("Finish ProjectScannerJob <<<");
    }
}
