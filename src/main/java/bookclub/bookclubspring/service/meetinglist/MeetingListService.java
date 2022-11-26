package bookclub.bookclubspring.service.meetinglist;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiryRepository;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.meetinglist.MeetingListRepository;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.domain.user.UserRepository;
import bookclub.bookclubspring.web.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class MeetingListService {
    private final MeetingListRepository meetingListRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, MeetingListSaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        MeetingList meetingList = requestDto.toEntity();
        meetingListRepository.save(meetingList);

        return meetingList.getId();
    }

    @Transactional
    public Long update(Long id, MeetingListUpdateRequestDto requestDto) {
        MeetingList meetingList = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id="+ id));

        meetingListRepository.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public MeetingListResponseDto findById (Long id) {
        DeveloperInquiry entity = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id="+ id));

        return new MeetingListResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return meetingListRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        MeetingList meetingList = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id=" + id));

        meetingListRepository.delete(meetingList);
    }
}
