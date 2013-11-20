package seeko.model;

import seeko.common.ScmType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by aceyin on 13-11-21.
 */
public class Repository implements Serializable {
    /* the name of the repository */
    @NotNull(message = "The name of a repository can not be null")
    private String name;
    /* the type of this repository */
    @NotNull(message = "The type of a repository can not be null")
    private ScmType type;
    /* the username of this repository */
    private String username;
    /* the password of this repository */
    private String password;
    /* the URL of this repository */
    @NotNull(message = "The URL of a repository can not be null")
    private String url;
    /* the exclusions of this repository */
    private String exclusions;
    /* the latest revision of this repository */
    private String latestRevision;
    /* the latest update time */
    private Long lastUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScmType getType() {
        return type;
    }

    public void setType(ScmType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getLatestRevision() {
        return latestRevision;
    }

    public void setLatestRevision(String latestRevision) {
        this.latestRevision = latestRevision;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repository that = (Repository) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }
}
