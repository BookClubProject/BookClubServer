package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ReviewSaveRequestDto {
    private User user;
    private Long postId;
    private String title;
    private String content;

    @Builder
    public ReviewSaveRequestDto(User user, Long postId, String title, String content) {
        this.user = user;
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public Review toEntity() {
        return Review.builder()
                .user(user)
                .postId(postId)
                .title(title)
                .content(content)
                .build();
    }



}
