package bookclub.bookclubspring.config.auth.dto;

import bookclub.bookclubspring.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // 인증된 사용자 정보만 필요
    private String name;
    private String email;
    private String mobile;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
    }
}
