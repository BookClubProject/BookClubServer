package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class RegisteredUserListResponseDto {
    private long id;
    private User user;
    private String name;
    private String mobile;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    public RegisteredUserListResponseDto(RegisteredUser entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.name = entity.getUser().getName();
        this.mobile = entity.getMobile();
        this.introduce = entity.getIntroduce();
        this.reservationReminder = entity.getReservationReminder();
        this.alert = entity.getAlert();
    }
}
