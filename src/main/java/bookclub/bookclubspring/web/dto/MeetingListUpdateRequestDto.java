package bookclub.bookclubspring.web.dto;

public class MeetingListUpdateRequestDto {
    private Boolean register;

    public MeetingListUpdateRequestDto(Boolean register) {
        this.register = register;
    }
}
