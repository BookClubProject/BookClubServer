package bookclub.bookclubspring.service.meetinglist;

import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiry;
import bookclub.bookclubspring.domain.developerinquiry.DeveloperInquiryRepository;
import bookclub.bookclubspring.domain.meetinglist.MeetingList;
import bookclub.bookclubspring.domain.meetinglist.MeetingListRepository;
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
public class MeetingListService {
    private final MeetingListRepository meetingListRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, MeetingListSaveRequestDto requestDto) {
        return meetingListRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MeetingListUpdateRequestDto requestDto) {
        MeetingList meetingList = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id="+ id));

        meetingList.update(requestDto.getRegister());
        return id;
    }

    public MeetingListResponseDto findById (Long id) {
        MeetingList entity = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id="+ id));

        return new MeetingListResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        MeetingList meetingList = meetingListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 신청 내역입니다. id=" + id));

        meetingListRepository.delete(meetingList);
    }
}
