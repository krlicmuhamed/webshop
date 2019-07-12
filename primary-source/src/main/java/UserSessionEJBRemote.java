import models.UsersEntity;

import javax.ejb.Local;

@Local
public interface UserSessionEJBRemote {
    UsersEntity findByLogin(String Email, String Password);
    void addUser(String email, String password, String phone, String address);
}
