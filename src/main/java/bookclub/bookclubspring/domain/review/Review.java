package bookclub.bookclubspring.domain.review;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String email;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Review(Long postId, String email, String title, String content) {
        this.postId = postId;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public void update(String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }
}
