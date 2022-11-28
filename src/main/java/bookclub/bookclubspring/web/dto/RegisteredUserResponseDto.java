package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class RegisteredUserResponseDto {
    private long id;
    private User user;
    private String name;
    private String mobile;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    public RegisteredUserResponseDto(RegisteredUser registeredUser) {
        this.id = registeredUser.getId();
        this.user = registeredUser.getUser();
        this.name = registeredUser.getUser().getName();
        this.mobile = registeredUser.getMobile();
        this.introduce = registeredUser.getIntroduce();
        this.reservationReminder = registeredUser.getReservationReminder();
        this.alert = registeredUser.getAlert();
    }
}
