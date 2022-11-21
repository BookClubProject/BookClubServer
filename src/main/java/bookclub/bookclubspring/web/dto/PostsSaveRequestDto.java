package bookclub.bookclubspring.web.dto;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsSaveRequestDto {
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
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(User user, String writer, String bookImage, String bookTitle, String price,
                               String publishDay, String publisher,
                               String year, String month, String date,
                               String day, String time, String state,
                               String location, String detailLocation, String theme,
                               String content, String author) {
        this.user = user;
        this.writer = writer;
        this.bookImage = bookImage;
        this.bookTitle = bookTitle;
        this.price = price;
        this.publishDay = publishDay;
        this.publisher = publisher;
        this.year = year;
        this.month = month;
        this.date = date;
        this.day = day;
        this.time = time;
        this.state = state;
        this.location = location;
        this.detailLocation = detailLocation;
        this.theme = theme;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .user(user)
                .writer(writer)
                .bookImage(bookImage)
                .bookTitle(bookTitle)
                .price(price)
                .publishDay(publishDay)
                .publisher(publisher)
                .year(year)
                .month(month)
                .date(date)
                .day(day)
                .time(time)
                .state(state)
                .location(location)
                .detailLocation(detailLocation)
                .theme(theme)
                .content(content)
                .author(author)
                .build();
    }
}
