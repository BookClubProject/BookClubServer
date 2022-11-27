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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "writer"))
    private User user;
    //private String writer;

    @Column()
    private Long postId;

    @Column(nullable = false)
    private Boolean register;

    @Builder
    public MeetingList (Long postId, User user, Boolean register) {
        this.postId = postId;
        this.user = user;
        this.register = register;
    }

    public void update (Boolean register) {
        this.register = register;
    }

}
