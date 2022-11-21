package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.review.Review;
import lombok.Builder;

public class ReviewSaveRequestDto {

    private Long postId;
    private String email;
    private String title;
    private String content;

    @Builder
    public ReviewSaveRequestDto(Long postId, String email, String title, String content) {
        this.postId = postId;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public Review toEntity() {
        return Review.builder()
                .postId(postId)
                .email(email)
                .title(title)
                .content(content)
                .build();
    }



}
