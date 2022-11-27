package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class MeetingListResponseDto {
    private Long id;
    private Long postId;
    private Posts posts;
    private User user;
    private String email;
    private Boolean register;

    public MeetingListResponseDto(MeetingList entity) {
        this.id = entity.getId();
        this.postId = entity.getPosts().getId();
        this.posts = entity.getPosts();
        this.user = entity.getUser();
        this.email = entity.getUser().getEmail();
        this.register = entity.getRegister();
    }
}
