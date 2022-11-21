package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;

public class RegisteredUserResponseDto {
    private long id;
    private String email;
    private String mobile;
    private String nickName;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    public RegisteredUserResponseDto(RegisteredUser entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.mobile = entity.getMobile();
        this.nickName = entity.getNickName();
        this.introduce = entity.getIntroduce();
        this.reservationReminder = entity.getReservationReminder();
        this.alert = entity.getAlert();
    }
}
