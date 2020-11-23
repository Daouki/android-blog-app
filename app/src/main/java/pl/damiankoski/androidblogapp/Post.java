package pl.damiankoski.androidblogapp;

import java.util.Date;

public class Post {
    private final int id;
    private String author;
    private String title;
    private String postContent;
    private Date dateOfPost;

    public Post(int id, String title, String author, Date dateOfPost, String postContent) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.postContent = postContent;
        this.dateOfPost = dateOfPost;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
