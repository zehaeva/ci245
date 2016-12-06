import java.nio.file.Path;

/**
 * Created by hcanaway on 12/6/2016.
 */
public class User {
    private String _user_name;
    private boolean _logged_in;

    public User(String userName) {
        this._user_name = userName;
        this._logged_in = false;
    }

    public String getUserName() {
        return _user_name;
    }

    public void setUserName(String userName) {
        this._user_name = userName;
    }
}
