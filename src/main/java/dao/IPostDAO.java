package dao;

import model.Post;

import java.util.List;

/**
 * Created by Hasmik on 08.07.2017.
 */
public interface IPostDAO {
    void addPost(Post post);
    List<Post> allPostByCategoryId (long id);
    List<Post> allPost ();



}
