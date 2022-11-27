package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.user.User;

public class DeveloperInquiryListDto {
    private Long id;
    private User user;
    private String writer;
    private String title;
    private String content;

    public DeveloperInquiryListDto(DeveloperInquiry developerInquiry) {
        this.id = developerInquiry.getId();
        this.user = developerInquiry.getUser();
        this.writer = developerInquiry.getUser().getName();
        this.title = developerInquiry.getTitle();
        this.content = developerInquiry.getContent();
    }
}
