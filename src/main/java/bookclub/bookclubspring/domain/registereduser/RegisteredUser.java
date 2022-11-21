package bookclub.bookclubspring.domain.registereduser;

import bookclub.bookclubspring.domain.user.Role;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RegisteredUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private Boolean reservationReminder;

    @Column(nullable = false)
    private Boolean alert;

    @Builder
    public RegisteredUser(String email, String mobile, String nickName, String introduce, Boolean reservationReminder, Boolean alert) {
        this.email = email;
        this.mobile = mobile;
        this.nickName = nickName;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }

    public RegisteredUser update(String mobile, String nickName, String introduce, Boolean reservationReminder, Boolean alert) {
        this.mobile = mobile;
        this.nickName = nickName;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;

        return this;
    }
}
