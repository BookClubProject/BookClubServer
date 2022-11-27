package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long id;
    private Long postId;
    private User user;
    private Long userId;
    private Posts posts;
    private String writer;
    private String title;
    private String content;

    public ReviewResponseDto(Review review) {
        this.id = review.getId();
        this.postId = review.getPosts().getId();
        this.posts = review.getPosts();
        this.user = review.getUser();
        this.userId = review.getUser().getId();
        this.writer = review.getUser().getName();
        this.title = review.getTitle();
        this.content = review.getContent();
    }
}
