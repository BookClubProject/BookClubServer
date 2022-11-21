package bookclub.bookclubspring.domain.user;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private Boolean reservationReminder;

    @Column(nullable = false)
    private Boolean alert;


    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String nickname, String email, String mobile, String introduce,
                String picture, Boolean reservationReminder, Boolean alert, Role role) {
        this.nickname = nickname;
        this.email = email;
        this.mobile = mobile;
        this.introduce = introduce;
        this.picture = picture;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
        this.role = role;
    }

    public User update(String nickname, String picture, String mobile, String introduce,
                       Boolean reservationReminder, Boolean alert) {
        this.nickname = nickname;
        this.picture = picture;
        this.mobile = mobile;
        this.introduce = introduce;
        this.reservationReminder = reservationReminder;
        this.alert = alert;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
