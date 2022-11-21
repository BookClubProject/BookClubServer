package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.meetinglist.MeetingList;

public class MeetingListResponseDto {
    private Long id;
    private Long postId;
    private String email;
    private Boolean register;

    public MeetingListResponseDto(MeetingList entity) {
        this.id = entity.getId();
        this.postId = entity.getPostId();
        this.email = entity.getEmail();
        this.register = entity.getRegister();
    }
}
