package seeko.common;

/**
 * Created by aceyin on 13-12-2.
 */
public enum Env {
    SEEKO_HOME("seeko.home"), SEEKO_DATA_DIR("seeko.data.dir");

    public final String key;

    private Env(String key) {
        this.key = key;
    }

    public String val() {
        return System.getProperty(this.key);
    }
}
