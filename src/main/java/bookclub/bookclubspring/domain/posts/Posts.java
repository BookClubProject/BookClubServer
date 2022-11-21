package bookclub.bookclubspring.domain.posts;

import bookclub.bookclubspring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String bookImage;

    @Column(length = 500, nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String publishDay;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String state;

    private String location;

    private String detailLocation;

    @Column(nullable = false)
    private String theme;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    @Builder
    public Posts(User user, String writer, String bookImage, String bookTitle, String price,
                 String publishDay, String publisher,
                 String year, String month, String date,
                 String day, String time, String state,
                 String location, String detailLocation, String theme,
                 String content, String author)  {
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

    public void update(String year, String month, String date, String day, String time, String state, String theme, String location, String detailLocation, String content) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.day = day;
        this.time = time;
        this.state = state;
        this.theme = theme;
        this.location = location;
        this.detailLocation = detailLocation;
        this.content = content;
    }
}
