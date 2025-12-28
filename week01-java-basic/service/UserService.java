package week01.service;

import week01.domain.User;
import week01.repository.*;
import java.util.*;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name) {
        // 이름 유효성 검증
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name is blank");
        }

        // 중복 이름 금지
        String normalized = name.trim();
        boolean exists = userRepository.findAll().stream()
                .anyMatch(u -> u.getName().equals(normalized));

        if (exists) {
            throw new IllegalArgumentException("duplicate name: " + normalized);
        }

        return userRepository.save(new User(name));
    }

    public Optional<User> findUser(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}