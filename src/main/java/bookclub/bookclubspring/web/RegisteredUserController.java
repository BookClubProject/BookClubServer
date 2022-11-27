package bookclub.bookclubspring.web;

import bookclub.bookclubspring.config.auth.LoginUser;
import bookclub.bookclubspring.config.auth.dto.SessionUser;
import bookclub.bookclubspring.domain.registereduser.RegisteredUser;
import bookclub.bookclubspring.domain.user.User;
import bookclub.bookclubspring.service.RegisteredUserService;
import bookclub.bookclubspring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegisteredUserController {
    private final RegisteredUserService registeredUserService;

    /* CREATE */
    @PostMapping("/api/v1/onlyuser")
    public ResponseEntity save(RegisteredUser registeredUser, User user, @RequestBody RegisteredUserSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {

        String name = sessionUser.getName();
        return ResponseEntity.ok(registeredUserService.save(name, requestDto));
    }

    @PutMapping("/api/v1/onlyuser/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    RegisteredUserUpdateRequestDto requestDto) {

        return registeredUserService.update(id, requestDto);
    }

    @GetMapping("/api/v1/onlyuser/read")
    public List<RegisteredUserListResponseDto> findAllDesc () {

        return registeredUserService.findAllDesc();
    }

    @GetMapping("/api/v1/onlyuser/{id}")
    public RegisteredUserResponseDto findById (@PathVariable Long id) {

        return registeredUserService.findById(id);
    }

    @DeleteMapping("/api/v1/onlyuser/{id}")
    public Long delete(@PathVariable Long id) {
        registeredUserService.delete(id);
        return id;
    }
}
