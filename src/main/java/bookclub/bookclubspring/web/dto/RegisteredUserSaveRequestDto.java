package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.user.User;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class RegisteredUserSaveRequestDto {
    private String mobile;
    private User user;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    @Builder
    public RegisteredUserSaveRequestDto(User user, String mobile, String introduce,
                                        Boolean reservationReminder, Boolean alert) {
        this.user = user;
        this.mobile = mobile;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }

    public RegisteredUser toEntity() {
        return RegisteredUser.builder()
                .user(user)
                .mobile(mobile)
                .introduce(introduce)
                .reservationReminder(reservationReminder)
                .alert(alert)
                .build();
    }
}
