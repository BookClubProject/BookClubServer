package bookclub.bookclubspring.service.PersonalInquiry;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiryRepository;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.domain.user.UserRepository;
import bookclub.bookclubspring.web.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalInquiryService {
    private final PersonalInquiryRepository personalInquiryRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, PersonalInquirySaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        PersonalInquiry personalInquiry = requestDto.toEntity();
        personalInquiryRepository.save(personalInquiry);

        return review.getId();
    }

    @Transactional
    public Long update(Long id, ReviewUpdateRequestDto requestDto) {
        PersonalInquiry personalInquiry = personalInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id="+ id));

        personalInquiry.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PersonalInquiryResponseDto findById (Long id) {
        PersonalInquiry entity = personalInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id="+ id));

        return new ReviewResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return personalInquiryRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        PersonalInquiry personalInquiry = personalInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id=" + id));

        personalInquiryRepository.delete(personalInquiry);
    }
}
