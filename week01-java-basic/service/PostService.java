package week01.service;

import week01.domain.Post;
import week01.domain.User;
import week01.repository.PostRepository;
import week01.repository.UserRepository;

import java.util.*;

public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Post CreatePost(Long userId, String title, String content) {
        // 제목 유효성 검증
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title is blank");
        }

        // 콘텐츠 유효성 검증
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("content is blank");
        }

        // 유저 존재 검증
        User author = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        return postRepository.save(new Post(title, content, author));
    }

    public Optional<Post> findPostById(Long postId) {
        return Optional.ofNullable(postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
    }

    public List<Post> findPostsByUserId(Long userId) {
        // User 존재 검증
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        // 해당 User가 작성한 글 목록 조회
        return postRepository.findAll().stream()
                .filter(post -> post.getAuthor().getId().equals(userId))
                .toList();
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
