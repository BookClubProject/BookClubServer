package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewListResponseDto {
    private Long id;
    private Long postId;
    private Posts posts;
    private User user;
    private String writer;
    private String title;
    private String content;

    public ReviewListResponseDto(Review entity) {
        this.id = entity.getId();
        this.postId = entity.getPosts().getId();
        this.posts = entity.getPosts();
        this.user = entity.getUser();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
