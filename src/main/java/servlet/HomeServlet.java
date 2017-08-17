package servlet;

import dao.CategoryDAOImpl;
import dao.ICategoryDAO;
import dao.IPostDAO;
import dao.PostDAOImpl;
import model.Category;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Hasmik on 09.07.2017.
 */
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        if (categoryId == null) {
            IPostDAO iPostDAO = new PostDAOImpl();
            List<Post> allThePosts = iPostDAO.allPost();
            req.setAttribute("allThePosts", allThePosts);
            ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
            List<Category> allCategory =  iCategoryDAO.getAllCategory();
            req.setAttribute("allCategory", allCategory);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            IPostDAO iPostDAO = new PostDAOImpl();
            List<Post> allPost = iPostDAO.allPostByCategoryId(Long.parseLong(categoryId));
            req.setAttribute("allPost", allPost);
            ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
            List<Category> allCategory =  iCategoryDAO.getAllCategory();
            req.setAttribute("allCategory", allCategory);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);

        }
    }
}
