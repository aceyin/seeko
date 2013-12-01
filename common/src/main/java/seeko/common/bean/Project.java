package seeko.common.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by aceyin on 13-11-30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
    @XmlAttribute
    private String name;
    @XmlElementWrapper(name = "repositories")
    @XmlElement(name = "repository")
    private List<Repository> repositories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
