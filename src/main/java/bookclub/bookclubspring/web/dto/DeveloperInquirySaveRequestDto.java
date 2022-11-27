package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class DeveloperInquirySaveRequestDto {
    private User user;
    private String email;
    private String title;
    private String content;

    @Builder
    public DeveloperInquirySaveRequestDto(User user, String email, String title, String content) {
        this.user = user;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public DeveloperInquiry toEntity() {
        return DeveloperInquiry.builder()
                .user(user)
                .email(email)
                .title(title)
                .content(content)
                .build();
    }
}
