package servlet;

import dao.CategoryDAOImpl;
import dao.ICategoryDAO;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        Category category = new Category();
        category.setName(categoryName);
        ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
        iCategoryDAO.addCategory(category);

        List<Category> allCategory =  iCategoryDAO.getAllCategory();
        req.setAttribute("allCategory", allCategory);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }


}
