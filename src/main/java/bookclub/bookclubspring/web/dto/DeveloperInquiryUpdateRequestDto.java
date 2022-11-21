package bookclub.bookclubspring.web.dto;

public class DeveloperInquiryUpdateRequestDto {
    private String title;
    private String content;

    public DeveloperInquiryUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
