package seeko.model;

import java.io.Serializable;

/**
 * Created by aceyin on 13-11-21.
 */
abstract class BaseModel implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
