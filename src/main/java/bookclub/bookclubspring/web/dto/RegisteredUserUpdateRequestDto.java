package bookclub.bookclubspring.web.dto;

import lombok.Builder;

public class RegisteredUserUpdateRequestDto {
    private String mobile;
    private String nickName;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    @Builder
    public RegisteredUserUpdateRequestDto(String mobile, String nickName, String introduce,
                                          Boolean reservationReminder, Boolean alert) {
        this.mobile = mobile;
        this.nickName = nickName;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }
}
