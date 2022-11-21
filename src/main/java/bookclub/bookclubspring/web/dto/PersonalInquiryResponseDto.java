package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;

public class PersonalInquiryResponseDto {
    private Long id;
    private Long postId;
    private String writer;
    private String title;
    private String content;

    public PersonalInquiryResponseDto(PersonalInquiry entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
