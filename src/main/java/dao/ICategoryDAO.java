package dao;

import model.Category;

import java.util.List;

/**
 * Created by Hasmik on 08.07.2017.
 */
public interface ICategoryDAO {
    void addCategory(Category category);
    List<Category> getAllCategory();
}
