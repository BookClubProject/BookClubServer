package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import lombok.Builder;

public class MeetingListSaveRequestDto {
    private String email;
    private Boolean register;

    @Builder
    public MeetingListSaveRequestDto(String email, Boolean register) {
        this.email = email;
        this.register = register;
    }

    public MeetingList toEntity() {
        return MeetingList.builder()
                .email(email)
                .register(register)
                .build();
    }
}
