package Blog;

/**
 * Created by sparatan117 on 12/14/16.
 */
public class User {
    private String loginName;

    public User(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
