package bookclub.bookclubspring.config.auth.dto;

import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // 인증된 사용자 정보만 필요
    private Long id;
    private String name;
    private String email;
    private String picture;
    private String mobile;
    private String introduce;
    private Boolean reservationReminder;
    private Boolean alert;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.mobile = user.getMobile();
        this.introduce = user.getIntroduce();
        this.reservationReminder = user.getReservationReminder();
        this.alert = getAlert();
    }
}
