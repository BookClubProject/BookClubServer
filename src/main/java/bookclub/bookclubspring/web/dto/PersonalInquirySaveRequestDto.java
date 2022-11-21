package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.review.Review;
import lombok.Builder;

public class PersonalInquirySaveRequestDto {
    private Long postId;
    private String writer;
    private String title;
    private String content;

    @Builder
    public PersonalInquirySaveRequestDto(Long postId, String writer, String title, String content) {
        this.postId = postId;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public PersonalInquiry toEntity() {
        return PersonalInquiry.builder()
                .postId(postId)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }

}
