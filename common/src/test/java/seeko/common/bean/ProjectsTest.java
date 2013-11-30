package seeko.common.bean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aceyin on 13-11-30.
 */
public class ProjectsTest {

    private String projectFile = ProjectsTest.class.getResource("/projects.xml").getFile();

    @Test
    public void test_normal() {
        Projects projects = Projects.load(projectFile);

        assertEquals("the projects should not be null", true, projects != null);
//        assertEquals("the projects size should be 1", 1, projects.size());
    }
}
