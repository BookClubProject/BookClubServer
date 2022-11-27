package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class MeetingListSaveRequestDto {
    private User user;
    private Long postId;
    private Boolean register;

    @Builder
    public MeetingListSaveRequestDto(User user, Long postId, Boolean register) {
        this.user = user;
        this.postId = postId;
        this.register = register;
    }

    public MeetingList toEntity() {
        return MeetingList.builder()
                .user(user)
                .postId(postId)
                .register(register)
                .build();
    }
}
