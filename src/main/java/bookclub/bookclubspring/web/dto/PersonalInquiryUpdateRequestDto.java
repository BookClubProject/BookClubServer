package bookclub.bookclubspring.web.dto;

public class PersonalInquiryUpdateRequestDto {
    private String title;
    private String content;
    private Boolean isAnswer;

    public PersonalInquiryUpdateRequestDto (String title, String content, Boolean isAnswer) {
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }
}
