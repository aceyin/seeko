package seeko.common.bean;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by aceyin on 13-11-30.
 */
public class ProjectsTest {

    private String projectFile = ProjectsTest.class.getResource("/projects.xml").getFile();

    @Test
    public void test_normal() {
        List<Project> projects = Projects.load(projectFile);

        assertEquals("the projects should not be null", true, projects != null);
        assertEquals("the projects size should be 1", 1, projects.size());

        Project project = projects.get(0);
        assertEquals("The project name should be 'test'", "test", project.getName());

        List<Repository> repositories = project.getRepositories();
        assertEquals("the repository size should be 1", 1, repositories.size());

        Repository repository = repositories.get(0);
        assertEquals("the repository type should be 'SVN'", "SVN", repository.getType());
        assertEquals("the repository url should be 'http://test.com/dev/test", "http://test.com/dev/test", repository.getUrl());

        Credential credential = repository.getCredential();
        assertEquals("the credential should not be null", true, credential != null);
        assertEquals("the credential name should be 'test_user", "test_user", credential.getName());
        assertEquals("the credential password should be '123456", "123456", credential.getPassword());

    }
}
