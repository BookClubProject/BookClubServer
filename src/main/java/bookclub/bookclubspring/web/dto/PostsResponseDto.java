package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private User user;
    private String writer;
    private Long userId;
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
    private String content;
    private String author;

    public PostsResponseDto(Posts posts) {
        this.id =  posts.getId();
        this.user = posts.getUser();
        this.userId = posts.getUser().getId();
        this.writer = posts.getWriter();
        this.bookImage = posts.getBookImage();
        this.bookTitle = posts.getBookTitle();
        this.price = posts.getPrice();
        this.publishDay = posts.getPublishDay();
        this.publisher = posts.getPublisher();
        this.year = posts.getYear();
        this.month = posts.getMonth();
        this.date = posts.getDate();
        this.day = posts.getDay();
        this.time = posts.getTime();
        this.state = posts.getState();
        this.location = posts.getLocation();
        this.detailLocation = posts.getDetailLocation();
        this.theme = posts.getTheme();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
