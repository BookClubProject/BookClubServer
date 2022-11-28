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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "name"))
    private User user;
    //private String name;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private Boolean reservationReminder = false;

    @Column(nullable = false)
    private Boolean alert = false;

    @Builder
    public RegisteredUser(User user, String mobile, String introduce, Boolean reservationReminder, Boolean alert) {
        this.user = user;
        this.mobile = mobile;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }

    public void update(User user, String mobile, String introduce, Boolean reservationReminder, Boolean alert) {
        this.user = user;
        this.mobile = mobile;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
    }
}
