package servlet;
import dao.IPostDAO;
import dao.PostDAOImpl;
import model.Post;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
public class AddPostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(50 * 1024);
            // Location to save data that is larger than maxMemSize.

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax(9900 * 1024);

            try {
                // Parse the request to get file items.
                List<FileItem> fileItems = upload.parseRequest(req);
                // Process the uploaded file items
                Iterator i = fileItems.iterator();
                Post post = new Post();
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        String fileName = fi.getName();
                        File file = new File("E:\\myBlog\\" +
                                "file_" + System.currentTimeMillis() + fileName);
                        fi.write(file);
                        post.setImage(file.getName());
                    } else if (fi.getFieldName().equals("title")) {
                        post.setTitle(fi.getString());
                    } else if (fi.getFieldName().equals("categoryId")) {
                        post.setCategoryId(Long.parseLong(fi.getString()));
                    } else if (fi.getFieldName().equals("description")) {
                        post.setDescription(fi.getString());
                    }
                }
                IPostDAO iPostDAO = new PostDAOImpl();
                iPostDAO.addPost(post);
            } catch (Exception e) {
                e.printStackTrace();


            }


        }
        resp.sendRedirect("admin.jsp");
    }

}



