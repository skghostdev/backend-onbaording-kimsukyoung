package week01.domain;

public class Post {
    private Long id;
    private String title;
    private String content;
    private User author;

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void assignId(Long id) { // package-private
        this.id = id;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getAuthor() { return author; }
}