package bookclub.bookclubspring.domain.developerinquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class DeveloperInquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public DeveloperInquiry (String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
