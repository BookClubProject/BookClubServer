package bookclub.bookclubspring.service;

import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.registereduser.RegisteredUserRepository;
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
public class RegisteredUserService {

    private final RegisteredUserRepository registeredUserRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(String name, RegisteredUserSaveRequestDto requestDto) {
        User user = userRepository.findByName(name);
        requestDto.setUser(user);

        RegisteredUser registeredUser = requestDto.toEntity();
        registeredUserRepository.save(registeredUser);

        return registeredUser.getId();
    }

    @Transactional
    public Long update(Long id, RegisteredUserUpdateRequestDto requestDto) {
        RegisteredUser registeredUser = registeredUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다. id="+ id));


        registeredUser.update(requestDto.getUser(), requestDto.getIntroduce(), requestDto.getMobile(),
                requestDto.getAlert(), requestDto.getReservationReminder());
        return id;
    }

    public RegisteredUserResponseDto findById (Long id) {
        RegisteredUser entity = registeredUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다. id="+ id));

        return new RegisteredUserResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        RegisteredUser registeredUser = registeredUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다. id=" + id));

        registeredUserRepository.delete(registeredUser);
    }
}
