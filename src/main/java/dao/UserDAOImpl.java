package dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by Hasmik on 10.07.2017.
 */
public class UserDAOImpl implements IUserDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public User getUserByUsernameAndPassword(String username, String password) {
        Query query = session.createQuery("from User U where U.username=:username AND U.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.uniqueResult();
    }

}
