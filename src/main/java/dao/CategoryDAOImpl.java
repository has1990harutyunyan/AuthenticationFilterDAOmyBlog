package dao;

import model.Category;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by Hasmik on 08.07.2017.
 */
public class CategoryDAOImpl implements ICategoryDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();


    public void addCategory(Category category) {
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();

    }

    public List<Category> getAllCategory() {
        return (List<Category>) session.createCriteria(Category.class).list();
    }
}
