package week01.repository;

import java.util.*;
import week01.domain.User;

public class UserRepository {
    private final Map<Long, User> store = new HashMap<>();
    private Long nextId = 1L;

    public User save(User user) {
        long id = nextId++;
        user.assignId(id);
        store.put(id, user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}