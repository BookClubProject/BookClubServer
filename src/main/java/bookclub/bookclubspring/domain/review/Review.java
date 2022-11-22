package bookclub.bookclubspring.domain.review;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
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

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String writer;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Review(Long postId, String writer, String title, String content) {
        this.postId = postId;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public void update(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
