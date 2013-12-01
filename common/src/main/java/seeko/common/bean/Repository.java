package seeko.common.bean;

import javax.xml.bind.annotation.*;

/**
 * Created by aceyin on 13-11-30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
    /**
     * The repository type.
     */
    @XmlTransient
    public static enum Type {
        SNV, GIT, CVS;
    }

    @XmlAttribute
    private String type;
    @XmlElement
    private Credential credential;
    @XmlElement
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
