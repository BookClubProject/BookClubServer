package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ReviewSaveRequestDto {

    private Long postId;
    private User user;
    private String writer;
    private String title;
    private String content;

    @Builder
    public ReviewSaveRequestDto(Long postId, User user, String writer, String title, String content) {
        this.postId = postId;
        this.user = user;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Review toEntity() {
        return Review.builder()
                .postId(postId)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }



}
