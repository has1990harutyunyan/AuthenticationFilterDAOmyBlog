package model;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "category_id")
    private long categoryId;
    private String description;
    private String image;
    @Column (name = "created_date")
    private String createdDate;

    public Post(String title, long categoryId, String description, String image, String createdDate) {
        this.title = title;
        this.categoryId = categoryId;
        this.description = description;
        this.image = image;
        this.createdDate = createdDate;
    }

    public Post () {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
