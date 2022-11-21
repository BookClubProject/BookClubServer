package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.review.Review;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long id;
    private Long postId;
    private String email;
    private String title;
    private String content;

    public ReviewResponseDto(Review entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.email = entity.getEmail();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
