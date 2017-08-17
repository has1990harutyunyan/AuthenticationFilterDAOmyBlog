package dao;

import model.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasmik on 08.07.2017.
 */
public class PostDAOImpl implements IPostDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void addPost(Post post) {
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }

    public List<Post> allPostByCategoryId(long id) {
        String hql = "from Post P where P.categoryId = :id order by P.createdDate desc";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.setMaxResults(2);
        return (List<Post>) query.list();

    }

    public List<Post> allPost() {
        return (List<Post>) session.createCriteria(Post.class).list();
    }


}


