package bookclub.bookclubspring.domain.review;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer")
    private User user;

    @Column()
    private Long postId;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Review(Long postId, User user, String title, String content) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
