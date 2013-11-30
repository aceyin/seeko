package seeko.common.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by aceyin on 13-11-30.
 */
public class Project {
    private String name;
    private List<Repository> repositories;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    @XmlElement
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
