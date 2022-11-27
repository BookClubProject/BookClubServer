package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long id;
    private Long postId;
    private User user;
    private String writer;
    private String title;
    private String content;

    public ReviewResponseDto(Review entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.user = entity.getUser();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
