package bookclub.bookclubspring.domai.posts;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_블러오기() {
        //given
        String bookTitle = "책제목";
        String bookImage = "책이미지";
        String price = "가격";
        String year = "연";
        String month = "월";
        String date = "일";
        String day = "요일";
        String time = "시간";
        String state = "온오프라인";
        String location = "주소";
        String detailLocation = "상세주소";
        String theme = "테마";
        String author = "저자";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .bookImage(bookImage)
                .bookTitle(bookTitle)
                .price(price)
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
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getBookImage()).isEqualTo(bookImage);
        assertThat(posts.getBookTitle()).isEqualTo(bookTitle);
        assertThat(posts.getPrice()).isEqualTo(price);
        assertThat(posts.getYear()).isEqualTo(year);
        assertThat(posts.getMonth()).isEqualTo(month);
        assertThat(posts.getDate()).isEqualTo(date);
        assertThat(posts.getDay()).isEqualTo(day);
        assertThat(posts.getTime()).isEqualTo(time);
        assertThat(posts.getState()).isEqualTo(state);
        assertThat(posts.getLocation()).isEqualTo(location);
        assertThat(posts.getDetailLocation()).isEqualTo(detailLocation);
        assertThat(posts.getTheme()).isEqualTo(theme);
        assertThat(posts.getAuthor()).isEqualTo(author);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2020,03,17,0,0,0);
        postsRepository.save(Posts.builder()
                .bookImage("bookImage")
                .bookTitle("bookTitle")
                .price("price")
                .year("year")
                .month("month")
                .date("date")
                .day("day")
                .time("time")
                .state("state")
                .location("location")
                .detailLocation("detailLocation")
                .theme("theme")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>> createDate="+posts.getCreateDate()
                +", modifiedDate="+posts.getModifiedDate());


        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
