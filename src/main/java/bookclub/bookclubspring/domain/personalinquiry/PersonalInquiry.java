package bookclub.bookclubspring.domain.personalinquiry;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PersonalInquiry extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String writer;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isAnswer = false;

    @Builder
    public PersonalInquiry (Long postId, String writer, String title, String content, Boolean isAnswer) {
        this.postId = postId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }

    public void update (String title, String content, Boolean isAnswer) {
        this.title = title;
        this.content = content;
        this.isAnswer = isAnswer;
    }

}
