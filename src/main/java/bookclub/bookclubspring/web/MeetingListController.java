package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.meetinglist.MeetingListService;
import bookclub.bookclubspring.service.review.ReviewService;
import bookclub.bookclubspring.web.dto.ReviewResponseDto;
import bookclub.bookclubspring.web.dto.ReviewSaveRequestDto;
import bookclub.bookclubspring.web.dto.ReviewUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class MeetingListController {
    private final MeetingListService meetingListService;

    /* CREATE */
    @PostMapping("/api/v1/meetinglistg")
    public ResponseEntity save(Posts posts, User user, @RequestBody ReviewSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String writer = sessionUser.getName();
        return ResponseEntity.ok(meetingListService.save(writer, requestDto));
    }

    @PutMapping("/api/v1/meetinglist/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    ReviewUpdateRequestDto requestDto) {

        return meetingListService.update(id, requestDto);
    }

    @GetMapping("/api/v1/meetinglist/{id}")
    public ReviewResponseDto findById (@PathVariable Long id) {

        return meetingListService.findById(id);
    }

    @DeleteMapping("/api/v1/meetinglist/{id}")
    public Long delete(@PathVariable Long id) {
        meetingListService.delete(id);
        return id;
    }
}
