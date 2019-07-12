import models.UsersEntity;

public class UserSessionFactory {
    private UsersEntity userObject;
    private boolean isLoggedIn = false;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public UsersEntity getUser() {
        return userObject;
    }

    public void setUser(UsersEntity userObject) {
        this.userObject = userObject;
    }
}
