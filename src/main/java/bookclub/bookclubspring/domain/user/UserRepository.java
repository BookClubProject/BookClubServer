package bookclub.bookclubspring.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /* OAuth */
    Optional<User> findByEmail(String email);

    /* user GET */
    User findByName (String name);

    boolean existsByName(String name);
    boolean existsByEmail(String email);
}