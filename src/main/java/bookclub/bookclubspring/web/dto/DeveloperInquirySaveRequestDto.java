package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import lombok.Builder;

public class DeveloperInquirySaveRequestDto {
    private String email;
    private String title;
    private String content;

    @Builder
    public DeveloperInquirySaveRequestDto(String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public DeveloperInquiry toEntity() {
        return DeveloperInquiry.builder()
                .email(email)
                .title(title)
                .content(content)
                .build();
    }
}
