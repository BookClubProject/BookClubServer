package bookclub.bookclubspring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonalInquiryUpdateRequestDto {
    private String title;
    private String content;
    private Boolean isAnswer;

    @Builder
    public PersonalInquiryUpdateRequestDto (String title, String content, Boolean isAnswer) {
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }
}
