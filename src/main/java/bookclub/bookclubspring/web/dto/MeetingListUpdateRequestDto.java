package bookclub.bookclubspring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MeetingListUpdateRequestDto {
    private Boolean register;

    @Builder
    public MeetingListUpdateRequestDto(Boolean register) {
        this.register = register;
    }
}
