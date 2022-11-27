package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.PersonalInquiry.PersonalInquiryService;
import bookclub.bookclubspring.service.review.ReviewService;
import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonalInquiryController {
    private final PersonalInquiryService personalInquiryService;

    /* CREATE */
    @PostMapping("/api/v1/posts/personalinquiry")
    public ResponseEntity save(PersonalInquiry personalInquiry, User user, @RequestBody PersonalInquirySaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String writer = sessionUser.getName();
        return ResponseEntity.ok(personalInquiryService.save(writer, requestDto));
    }

    @PutMapping("/api/v1/posts/personalinquiry/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    PersonalInquiryUpdateRequestDto requestDto) {

        return personalInquiryService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/personalinquiry/{id}")
    public PersonalInquiryResponseDto findById (@PathVariable Long id) {

        return personalInquiryService.findById(id);
    }
    @GetMapping("/api/v1/posts/personalinquiry/read")
    public List<PersonalInquiryListDto> findAllDesc () {

        return personalInquiryService.findAllDesc();
    }

    @DeleteMapping("/api/v1/posts/personalinquiry/{id}")
    public Long delete(@PathVariable Long id) {
        personalInquiryService.delete(id);
        return id;
    }
}
