package bookclub.bookclubspring.domain.user;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import lombok.AllArgsConstructor;
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
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String mobile;

    @Column
    private String introduce;

    @Column
    private Boolean reservationReminder = false;

    @Column
    private Boolean alert = false;


    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String mobile, String introduce,
                String picture, Boolean reservationReminder, Boolean alert, Role role) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.introduce = introduce;
        this.picture = picture;
        this.reservationReminder = reservationReminder;
        this.alert = alert;
        this.role = role;
    }

    public User update(String name, String picture, String mobile, String introduce,
                       Boolean reservationReminder, Boolean alert) {
        this.name = name;
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
