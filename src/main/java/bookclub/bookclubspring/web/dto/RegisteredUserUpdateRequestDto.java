package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisteredUserUpdateRequestDto {
    private String mobile;
    private User user;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    @Builder
    public RegisteredUserUpdateRequestDto(User user, String mobile, String introduce,
                                          Boolean reservationReminder, Boolean alert) {
        this.mobile = mobile;
        this.user = user;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }
}
