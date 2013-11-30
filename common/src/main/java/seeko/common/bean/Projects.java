package seeko.common.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

/**
 * Created by aceyin on 13-11-30.
 */
@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class Projects {
    @XmlTransient
    private static final Logger LOGGER = LoggerFactory.getLogger(Projects.class);

    @XmlElement(name = "project")
    private List<Project> projects;

    /**
     * Load projects from XML file .
     */
    public static Projects load(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Projects.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Projects projects = (Projects) unmarshaller.unmarshal(new File(fileName));
            if (projects == null) {
                LOGGER.warn("No projects found in file :" + fileName);
                return null;
            }
            return projects;

        } catch (JAXBException e) {
            throw new RuntimeException("Error while parse the projects.xml file", e);
        }
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
