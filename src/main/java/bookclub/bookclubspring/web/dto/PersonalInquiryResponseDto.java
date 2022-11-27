package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class PersonalInquiryResponseDto {
    private Long id;
    private Long postId;
    private Posts posts;
    private User user;
    private String writer;
    private String title;
    private String content;
    private Boolean isAnswer;

    public PersonalInquiryResponseDto(PersonalInquiry entity) {
        this.id = entity.getId();
        this.postId = entity.getPosts().getId();
        this.posts = entity.getPosts();
        this.user = entity.getUser();
        this.writer = entity.getUser().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.isAnswer = entity.getIsAnswer();
    }
}
