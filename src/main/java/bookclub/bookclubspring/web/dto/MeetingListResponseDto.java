package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class MeetingListResponseDto {
    private Long id;
    private Long postId;
    private User user;
    private String name;
    private Boolean register;

    public MeetingListResponseDto(MeetingList meetingList) {
        this.id = meetingList.getId();
        this.postId = meetingList.getPostId();
        this.user = meetingList.getUser();
        this.name = meetingList.getUser().getName();
        this.register = meetingList.getRegister();
    }
}
