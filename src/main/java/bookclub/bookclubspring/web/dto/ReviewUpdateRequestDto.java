package bookclub.bookclubspring.web.dto;

import lombok.Builder;

public class ReviewUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ReviewUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
