package seeko.common.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aceyin on 13-11-30.
 */
public class Repository {
    /**
     * The repository type.
     */
    public static enum Type {
        SNV, GIT, CVS;
    }

    private String type;
    private Credential credential;

    public String getType() {
        return type;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    public Credential getCredential() {
        return credential;
    }

    @XmlElement
    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
