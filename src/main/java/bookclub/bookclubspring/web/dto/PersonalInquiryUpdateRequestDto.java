package bookclub.bookclubspring.web.dto;

public class PersonalInquiryUpdateRequestDto {
    private String title;
    private String content;

    public PersonalInquiryUpdateRequestDto (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
