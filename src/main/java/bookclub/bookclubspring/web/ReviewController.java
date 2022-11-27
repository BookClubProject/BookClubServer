package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.posts.Posts;
import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.review.ReviewService;
import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    /* CREATE */
    @PostMapping("/api/v1/posts/{postId}/reviews")
    public ResponseEntity save(Review review, User user, @RequestBody ReviewSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String writer = sessionUser.getName();
        return ResponseEntity.ok(reviewService.save(writer, requestDto));
    }

    @PutMapping("/api/v1/posts/{postId}/reviews/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    ReviewUpdateRequestDto requestDto) {

        return reviewService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{postId}/reviews/{id}")
    public ReviewResponseDto findById (@PathVariable Long id) {

        return reviewService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{postId}/reviews/{id}")
    public Long delete(@PathVariable Long id) {
        reviewService.delete(id);
        return id;
    }
}
