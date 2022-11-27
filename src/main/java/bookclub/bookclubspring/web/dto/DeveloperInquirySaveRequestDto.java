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
    private String title;
    private String content;

    @Builder
    public DeveloperInquirySaveRequestDto(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public DeveloperInquiry toEntity() {
        return DeveloperInquiry.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }
}
