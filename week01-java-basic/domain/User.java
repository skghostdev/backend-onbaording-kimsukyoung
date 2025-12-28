package week01.domain;

public class User {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void assignId(Long id) { // package-private
        this.id = id;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}