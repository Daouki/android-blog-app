package pl.damiankoski.androidblogapp;

import java.util.Date;

public class Post {
    private final int id;
    private String authors;
    private String title;
    private String postContent;
    private Date dateOfPost;

    public Post(int id, String authors, String title, String postContent, Date dateOfPost) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.postContent = postContent;
        this.dateOfPost = dateOfPost;
    }

    public String get_author() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public int getId() {
        return id;
    }
}
