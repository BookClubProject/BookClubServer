package bookclub.bookclubspring.domain.meetinglist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MeetingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean register;

    @Builder
    public MeetingList (Long postId, String email, Boolean register) {
        this.postId = postId;
        this.email = email;
        this.register = register;
    }

    public void update (Boolean register) {
        this.register = register;
    }

}
