package week01.repository;

import week01.domain.*;

import java.util.*;

public class PostRepository {
    private Map<Long, Post> store = new HashMap<Long, Post>();
    private Long nextId = 1L;

    public Post save(Post post) {
        long id = nextId++;
        post.assignId(id);
        store.put(id, post);
        return post;
    }

    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }
}
