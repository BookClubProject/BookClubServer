package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.review.Review;
import lombok.Builder;

public class PersonalInquirySaveRequestDto {
    private Long postId;
    private String writer;
    private String title;
    private String content;
    private Boolean isAnswer;

    @Builder
    public PersonalInquirySaveRequestDto(Long postId, String writer, String title, String content, Boolean isAnswer) {
        this.postId = postId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }

    public PersonalInquiry toEntity() {
        return PersonalInquiry.builder()
                .postId(postId)
                .writer(writer)
                .title(title)
                .content(content)
                .isAnswer(isAnswer)
                .build();
    }

}
