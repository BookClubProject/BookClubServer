package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;

public class DeveloperInquiryResponseDto {
    private Long id;
    private String email;
    private String title;
    private String content;

    public DeveloperInquiryResponseDto(DeveloperInquiry entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
