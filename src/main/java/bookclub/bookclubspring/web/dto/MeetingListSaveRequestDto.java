package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class MeetingListSaveRequestDto {
    private User user;
    private String email;
    private Boolean register;

    @Builder
    public MeetingListSaveRequestDto(User user, String email, Boolean register) {
        this.user = user;
        this.email = email;
        this.register = register;
    }

    public MeetingList toEntity() {
        return MeetingList.builder()
                .user(user)
                .email(email)
                .register(register)
                .build();
    }
}
