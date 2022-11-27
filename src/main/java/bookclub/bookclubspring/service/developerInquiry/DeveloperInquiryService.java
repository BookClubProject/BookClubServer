package bookclub.bookclubspring.service.developerInquiry;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiryRepository;
import bookclub.bookclubspring.domain.review.Review;
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
public class DeveloperInquiryService {
    private final DeveloperInquiryRepository developerInquiryRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, DeveloperInquirySaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        DeveloperInquiry developerInquiry = requestDto.toEntity();
        developerInquiryRepository.save(developerInquiry);

        return developerInquiry.getId();
    }

    @Transactional
    public Long update(Long id, DeveloperInquiryUpdateRequestDto requestDto) {
        DeveloperInquiry developerInquiry = developerInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id="+ id));

        developerInquiry.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public DeveloperInquiryResponseDto findById (Long id) {
        DeveloperInquiry entity = developerInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id="+ id));

        return new DeveloperInquiryResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<DeveloperInquiryListDto> findAllDesc() {
        return developerInquiryRepository.findAllDesc().stream()
                .map(DeveloperInquiryListDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id) {
        DeveloperInquiry developerInquiry = developerInquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의가 존재하지 않습니다. id=" + id));

        developerInquiryRepository.delete(developerInquiry);
    }
}
