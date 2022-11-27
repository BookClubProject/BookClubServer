package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class PersonalInquirySaveRequestDto {
    private Long postId;
    private User user;
    private String title;
    private String content;
    private Boolean isAnswer;

    @Builder
    public PersonalInquirySaveRequestDto(Long postId, User user, String title, String content, Boolean isAnswer) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }

    public PersonalInquiry toEntity() {
        return PersonalInquiry.builder()
                .user(user)
                .postId(postId)
                .title(title)
                .content(content)
                .isAnswer(isAnswer)
                .build();
    }

}
