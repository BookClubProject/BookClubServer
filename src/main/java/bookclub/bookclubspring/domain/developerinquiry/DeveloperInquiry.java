package bookclub.bookclubspring.domain.developerinquiry;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class DeveloperInquiry extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String email;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public DeveloperInquiry (User user, String email, String title, String content) {
        this.user = user;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
