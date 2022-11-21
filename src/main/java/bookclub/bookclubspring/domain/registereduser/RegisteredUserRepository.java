package bookclub.bookclubspring.domain.registereduser;

import bookclub.bookclubspring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

    Optional<User> findByEmail(String email);
}
