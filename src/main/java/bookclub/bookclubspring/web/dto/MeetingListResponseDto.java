package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class MeetingListResponseDto {
    private Long id;
    private Long postId;
    private User user;
    private String email;
    private Boolean register;

    public MeetingListResponseDto(MeetingList entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.user = entity.getUser();
        this.email = entity.getEmail();
        this.register = entity.getRegister();
    }
}
