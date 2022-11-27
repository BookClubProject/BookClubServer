package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class DeveloperInquiryResponseDto {
    private Long id;
    private User user;
    private String email;
    private String title;
    private String content;

    public DeveloperInquiryResponseDto(DeveloperInquiry entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.email = entity.getUser().getEmail();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
