package bookclub.bookclubspring.domain.meetinglist;

import bookclub.bookclubspring.domain.posts.BaseTimeEntity;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MeetingList extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Posts posts;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean register;

    @Builder
    public MeetingList (Long postId, Posts posts, User user, String email, Boolean register) {
        this.postId = postId;
        this.posts = posts;
        this.user = user;
        this.email = email;
        this.register = register;
    }

    public void update (Boolean register) {
        this.register = register;
    }

}
