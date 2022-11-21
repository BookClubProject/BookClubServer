package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;

public class RegisteredUserSaveRequestDto {
    private String email;
    private String mobile;
    private String nickName;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    public RegisteredUserSaveRequestDto(String email, String mobile, String nickName, String introduce,
                                        Boolean reservationReminder, Boolean alert) {
        this.email = email;
        this.mobile = mobile;
        this.nickName = nickName;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }

    public RegisteredUser toEntity() {
        return RegisteredUser.builder()
                .email(email)
                .mobile(mobile)
                .nickName(nickName)
                .introduce(introduce)
                .reservationReminder(reservationReminder)
                .alert(alert)
                .build();
    }
}
