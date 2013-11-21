package seeko.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by aceyin on 13-11-20.
 */
public class Admin extends BaseModel implements Serializable {
    @NotNull(message = "The username can not be null")
    @Max(value = 32, message = "The username can not exceeds 32 characters")
    private String username;
    @NotNull(message = "The password can not be null")
    @Max(value = 32, message = "The password can not exceeds 32 characters")
    private String password;

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

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;
        if (username != null ? !username.equals(admin.username) : admin.username != null) return false;

        return true;
    }
}
