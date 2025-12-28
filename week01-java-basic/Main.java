package week01;

import week01.domain.Post;
import week01.domain.User;
import week01.repository.PostRepository;
import week01.repository.UserRepository;
import week01.service.PostService;
import week01.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Repository 초기화
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        
        // Service 초기화
        UserService userService = new UserService(userRepository);
        PostService postService = new PostService(userRepository, postRepository);
        
        System.out.println("=== Week01 기능 테스트 ===\n");
        
        // 1. 유저 생성
        System.out.println("1. 유저 생성");
        User user1 = userService.createUser("김수경");
        User user2 = userService.createUser("석지혜");
        User user3 = userService.createUser("김민주");
        System.out.println("   - 생성된 유저: " + user1.getName() + " (ID: " + user1.getId() + ")");
        System.out.println("   - 생성된 유저: " + user2.getName() + " (ID: " + user2.getId() + ")");
        System.out.println("   - 생성된 유저: " + user3.getName() + " (ID: " + user3.getId() + ")");
        System.out.println();
        
        // 2. 게시글 생성
        System.out.println("2. 게시글 생성");
        Post post1 = postService.CreatePost(user1.getId(), "첫 번째 글", "안녕하세요!");
        Post post2 = postService.CreatePost(user2.getId(), "두 번째 글", "반갑습니다!");
        Post post3 = postService.CreatePost(user3.getId(), "세 번째 글", "Hello World!");
        System.out.println("   - 생성된 게시글: " + post1.getTitle() + " (ID: " + post1.getId() + ", 작성자: " + post1.getAuthor().getName() + ")");
        System.out.println("   - 생성된 게시글: " + post2.getTitle() + " (ID: " + post2.getId() + ", 작성자: " + post2.getAuthor().getName() + ")");
        System.out.println("   - 생성된 게시글: " + post3.getTitle() + " (ID: " + post3.getId() + ", 작성자: " + post3.getAuthor().getName() + ")");
        System.out.println();
        
        // 3. 전체 게시글 목록 출력
        System.out.println("3. 전체 게시글 목록 출력");
        List<Post> allPosts = postService.findAllPosts();
        System.out.println("   총 게시글 수: " + allPosts.size());
        allPosts.forEach(post -> {
            System.out.println("   - [ID: " + post.getId() + "] " + post.getTitle() + 
                             " (작성자: " + post.getAuthor().getName() + ")");
        });
        System.out.println();
        
        // 추가 테스트: 유저별 게시글 조회
        System.out.println("4. 유저별 게시글 조회");
        List<Post> user1Posts = postService.findPostsByUserId(user1.getId());
        System.out.println("   " + user1.getName() + "의 게시글 수: " + user1Posts.size());
        user1Posts.forEach(post -> {
            System.out.println("   - " + post.getTitle());
        });
        System.out.println();
        
        List<Post> user2Posts = postService.findPostsByUserId(user2.getId());
        System.out.println("   " + user2.getName() + "의 게시글 수: " + user2Posts.size());
        user2Posts.forEach(post -> {
            System.out.println("   - " + post.getTitle());
        });
        System.out.println();

        List<Post> user3Posts = postService.findPostsByUserId(user3.getId());
        System.out.println("   " + user3.getName() + "의 게시글 수: " + user2Posts.size());
        user2Posts.forEach(post -> {
            System.out.println("   - " + post.getTitle());
        });
        System.out.println();
        
        // 추가 테스트: 전체 유저 목록
        System.out.println("5. 전체 유저 목록");
        List<User> allUsers = userService.findAllUsers();
        System.out.println("   총 유저 수: " + allUsers.size());
        allUsers.forEach(user -> {
            System.out.println("   - [ID: " + user.getId() + "] " + user.getName());
        });
        System.out.println();
        
        // 추가 테스트: 게시글 단건 조회
        System.out.println("6. 게시글 단건 조회");
        postService.findPostById(post1.getId()).ifPresent(post -> {
            System.out.println("   제목: " + post.getTitle());
            System.out.println("   내용: " + post.getContent());
            System.out.println("   작성자: " + post.getAuthor().getName());
        });
        System.out.println();
        
        System.out.println("=== 테스트 완료 ===");

        // Main 클래스 끝부분에 추가

        System.out.println("=== 예외 케이스 테스트 ===\n");
        
        // UserService 예외 테스트
        System.out.println("7. UserService 예외 테스트");
        
        // 7-1. name이 null인 경우
        try {
            userService.createUser(null);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ name이 null: " + e.getMessage());
        }
        
        // 7-2. name이 빈 문자열인 경우
        try {
            userService.createUser("");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ name이 빈 문자열: " + e.getMessage());
        }
        
        // 7-3. name이 공백만 있는 경우
        try {
            userService.createUser("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ name이 공백만: " + e.getMessage());
        }
        
        // 7-4. 중복 이름인 경우
        try {
            userService.createUser("김수경");  // 이미 생성된 이름
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ 중복 이름: " + e.getMessage());
        }
        System.out.println();
        
        // PostService 예외 테스트
        System.out.println("8. PostService 예외 테스트");
        
        // 8-1. title이 null인 경우
        try {
            postService.CreatePost(user1.getId(), null, "content");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ title이 null: " + e.getMessage());
        }
        
        // 8-2. title이 빈 문자열인 경우
        try {
            postService.CreatePost(user1.getId(), "", "content");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ title이 빈 문자열: " + e.getMessage());
        }
        
        // 8-3. content가 null인 경우
        try {
            postService.CreatePost(user1.getId(), "title", null);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ content가 null: " + e.getMessage());
        }
        
        // 8-4. content가 빈 문자열인 경우
        try {
            postService.CreatePost(user1.getId(), "title", "");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ content가 빈 문자열: " + e.getMessage());
        }
        
        // 8-5. 존재하지 않는 userId로 게시글 생성
        try {
            postService.CreatePost(999L, "title", "content");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ 존재하지 않는 userId: " + e.getMessage());
        }
        
        // 8-6. 존재하지 않는 postId로 조회
        try {
            postService.findPostById(999L);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ 존재하지 않는 postId: " + e.getMessage());
        }
        
        // 8-7. 존재하지 않는 userId로 게시글 목록 조회
        try {
            postService.findPostsByUserId(999L);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ 존재하지 않는 userId로 목록 조회: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== 모든 테스트 완료 ===");
    }
}