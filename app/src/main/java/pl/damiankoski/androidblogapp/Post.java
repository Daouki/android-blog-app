package pl.damiankoski.androidblogapp;

import java.util.Date;

public class Post {
    private final int _id;
    private String _authors;
    private String _Title;
    private String _postContent;
    private Date _dateOfPost;

    public Post(int id, String authors, String title, String postContent, Date dateOfPost) {
        _id = id;
        _authors = authors;
        _Title = title;
        _postContent = postContent;
        _dateOfPost = dateOfPost;
    }

    public String get_authors() {
        return _authors;
    }

    public void set_authors(String _authors) {
        this._authors = _authors;
    }

    public String get_Title() {
        return _Title;
    }

    public void set_Title(String _Title) {
        this._Title = _Title;
    }

    public String get_postContent() {
        return _postContent;
    }

    public void set_postContent(String _postContent) {
        this._postContent = _postContent;
    }

    public Date get_dateOfPost() {
        return _dateOfPost;
    }

    public void set_dateOfPost(Date _dateOfPost) {
        this._dateOfPost = _dateOfPost;
    }

    public int get_id() {
        return _id;
    }
}
