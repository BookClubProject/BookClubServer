package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.user.User;

public class MeetingListAllDto {
    private Long id;
    private Long postId;
    private User user;
    private String writer;
    private Boolean register;

    public MeetingListAllDto(MeetingList meetingList) {
        this.id = meetingList.getId();
        this.postId = meetingList.getPostId();
        this.user = meetingList.getUser();
        this.writer = meetingList.getUser().getName();
        this.register = meetingList.getRegister();
    }
}
