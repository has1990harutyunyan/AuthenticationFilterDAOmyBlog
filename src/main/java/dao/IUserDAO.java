package dao;

import model.User;

/**
 * Created by Hasmik on 10.07.2017.
 */
public interface IUserDAO {
    User getUserByUsernameAndPassword(String username, String password);


}
