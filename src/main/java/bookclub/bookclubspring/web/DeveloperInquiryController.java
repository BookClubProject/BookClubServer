package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.developerInquiry.DeveloperInquiryService;
import bookclub.bookclubspring.service.review.ReviewService;
import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DeveloperInquiryController {

    private final DeveloperInquiryService developerInquiryService;

    /* CREATE */
    @PostMapping("/api/v1/developerinquiry")
    public ResponseEntity save(DeveloperInquiry developerInquiry, User user, @RequestBody DeveloperInquirySaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String writer = sessionUser.getName();
        return ResponseEntity.ok(developerInquiryService.save(writer, requestDto));
    }

    @PutMapping("/api/v1/developerinquiry/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    DeveloperInquiryUpdateRequestDto requestDto) {

        return developerInquiryService.update(id, requestDto);
    }

    @GetMapping("/api/v1/developerinquiry/{id}")
    public DeveloperInquiryResponseDto findById (@PathVariable Long id) {

        return developerInquiryService.findById(id);
    }

    @DeleteMapping("/api/v1/developerinquiry/{id}")
    public Long delete(@PathVariable Long id) {
        developerInquiryService.delete(id);
        return id;
    }
}
