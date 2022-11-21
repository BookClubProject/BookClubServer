package bookclub.bookclubspring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
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

    @Builder
    public PostsUpdateRequestDto(String year, String month, String date, String day, String time, String state, String location, String detailLocation, String theme, String content) {
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
    }
}
