package bookclub.bookclubspring.web;

import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.posts.PostsRepository;
import bookclub.bookclubspring.web.dto.PostsSaveRequestDto;
import bookclub.bookclubspring.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        //given
        String bookTitle = "bookTitle";
        String content = "content";
        String bookImage = "bookImage";
        String price ="price";
        String year = "year";
        String month = "month";
        String date = "date";
        String day = "day";
        String time = "time";
        String state = "state";
        String location = "location";
        String detailLocation = "detailLocation";
        String theme = "theme";
        String author = "author";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
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
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getBookImage()).isEqualTo(bookImage);
        assertThat(all.get(0).getBookTitle()).isEqualTo(bookTitle);
        assertThat(all.get(0).getPrice()).isEqualTo(price);
        assertThat(all.get(0).getYear()).isEqualTo(year);
        assertThat(all.get(0).getMonth()).isEqualTo(month);
        assertThat(all.get(0).getDate()).isEqualTo(date);
        assertThat(all.get(0).getDay()).isEqualTo(day);
        assertThat(all.get(0).getTime()).isEqualTo(time);
        assertThat(all.get(0).getState()).isEqualTo(state);
        assertThat(all.get(0).getLocation()).isEqualTo(location);
        assertThat(all.get(0).getDetailLocation()).isEqualTo(detailLocation);
        assertThat(all.get(0).getTheme()).isEqualTo(theme);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    public void Posts_수정된다() throws Exception {
        //given
        Posts savePosts = postsRepository.save(Posts.builder()
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
                .build());

        Long updateId = savePosts.getId();
        String expectedYear = "year2";
        String expectedMonth = "month2";
        String expectedDate = "date2";
        String expectedDay = "day2";
        String expectedTime = "time2";
        String expectedState = "state2";
        String expectedLocation = "location2";
        String expectedDetailLocation = "detailLocation2";
        String expectedTheme = "theme2";
        String expectedContent = "content2";
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .year(expectedYear)
                .month(expectedMonth)
                .date(expectedDate)
                .day(expectedDay)
                .time(expectedTime)
                .state(expectedState)
                .location(expectedLocation)
                .detailLocation(expectedDetailLocation)
                .theme(expectedTheme)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getYear()).isEqualTo(expectedYear);
        assertThat(all.get(0).getMonth()).isEqualTo(expectedMonth);
        assertThat(all.get(0).getDate()).isEqualTo(expectedDate);
        assertThat(all.get(0).getDay()).isEqualTo(expectedDay);
        assertThat(all.get(0).getTime()).isEqualTo(expectedTime);
        assertThat(all.get(0).getState()).isEqualTo(expectedState);
        assertThat(all.get(0).getLocation()).isEqualTo(expectedLocation);
        assertThat(all.get(0).getDetailLocation()).isEqualTo(expectedDetailLocation);
        assertThat(all.get(0).getTheme()).isEqualTo(expectedTheme);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}
