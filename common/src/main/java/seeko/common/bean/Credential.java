package seeko.common.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by aceyin on 13-11-30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Credential {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
