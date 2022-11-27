package bookclub.bookclubspring.service.review;

import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.domain.review.ReviewRepository;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.domain.user.UserRepository;
import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, ReviewSaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        Review review = requestDto.toEntity();
        reviewRepository.save(review);

        return review.getId();
    }

    @Transactional
    public Long update(Long id, ReviewUpdateRequestDto requestDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 없습니다. id="+ id));


        review.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public ReviewResponseDto findById (Long id) {
         Review entity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 없습니다. id="+ id));

        return new ReviewResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ReviewListResponseDto> findAllDesc() {
        return reviewRepository.findAllDesc().stream()
                .map(ReviewListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        reviewRepository.delete(review);
    }
}
