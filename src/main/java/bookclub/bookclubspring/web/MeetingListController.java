package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.meetinglist.MeetingListService;

import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class MeetingListController {
    private final MeetingListService meetingListService;

    /* CREATE */
    @PostMapping("/api/v1/meetinglist")
    public ResponseEntity save(MeetingList meetingList, User user, @RequestBody MeetingListSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String email = sessionUser.getEmail();
        return ResponseEntity.ok(meetingListService.save(email, requestDto));
    }

    @PutMapping("/api/v1/meetinglist/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    MeetingListUpdateRequestDto requestDto) {

        return meetingListService.update(id, requestDto);
    }

    @GetMapping("/api/v1/meetinglist/{id}")
    public MeetingListResponseDto findById (@PathVariable Long id) {

        return meetingListService.findById(id);
    }

    @DeleteMapping("/api/v1/meetinglist/{id}")
    public Long delete(@PathVariable Long id) {
        meetingListService.delete(id);
        return id;
    }
}
