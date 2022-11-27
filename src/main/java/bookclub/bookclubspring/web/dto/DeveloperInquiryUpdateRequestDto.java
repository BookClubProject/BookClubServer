package bookclub.bookclubspring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeveloperInquiryUpdateRequestDto {
    private String title;
    private String content;
    @Builder
    public DeveloperInquiryUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
