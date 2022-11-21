package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.review.Review;
import lombok.Builder;

public class PersonalInquirySaveRequestDto {
    private Long postId;
    private String email;
    private String title;
    private String content;

    @Builder
    public PersonalInquirySaveRequestDto(Long postId, String email, String title, String content) {
        this.postId = postId;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public PersonalInquiry toEntity() {
        return PersonalInquiry.builder()
                .postId(postId)
                .email(email)
                .title(title)
                .content(content)
                .build();
    }

}
