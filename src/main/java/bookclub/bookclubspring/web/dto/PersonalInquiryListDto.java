package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.user.User;

public class PersonalInquiryListDto {
    private Long id;
    private Long postId;
    private User user;
    private String writer;
    private String title;
    private String content;
    private Boolean isAnswer;

    public PersonalInquiryListDto(PersonalInquiry entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.user = entity.getUser();
        this.writer = entity.getUser().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.isAnswer = entity.getIsAnswer();
    }
}
