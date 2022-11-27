package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private User user;
    private String writer;
    private String bookImage;
    private String bookTitle;
    private String price;
    private String publishDay;
    private String publisher;
    private String year;
    private String month;
    private String date;
    private String day;
    private String time;
    private String state;
    private String location;
    private String detailLocation;
    private String theme;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.writer = entity.getUser().getName();
        this.bookImage = entity.getBookImage();
        this.bookTitle = entity.getBookTitle();
        this.price = entity.getPrice();
        this.publishDay = entity.getPublishDay();
        this.publisher = entity.getPublisher();
        this.year = entity.getYear();
        this.month = entity.getMonth();
        this.date = entity.getDate();
        this.day = entity.getDay();
        this.time = entity.getTime();
        this.state = entity.getState();
        this.location = entity.getLocation();
        this.detailLocation = entity.getDetailLocation();
        this.theme = entity.getTheme();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
