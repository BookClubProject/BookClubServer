package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class DeveloperInquiryResponseDto {
    private Long id;
    private User user;
    private String writer;
    private String title;
    private String content;

    public DeveloperInquiryResponseDto(DeveloperInquiry developerInquiry) {
        this.id = developerInquiry.getId();
        this.user = developerInquiry.getUser();
        this.writer = developerInquiry.getUser().getName();
        this.title = developerInquiry.getTitle();
        this.content = developerInquiry.getContent();
    }
}
