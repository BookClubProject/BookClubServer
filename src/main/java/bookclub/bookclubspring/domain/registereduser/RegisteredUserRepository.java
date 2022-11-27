package bookclub.bookclubspring.domain.registereduser;

import bookclub.bookclubspring.domain.personalinquiry.PersonalInquiry;
import bookclub.bookclubspring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

    @Query("SELECT p From RegisteredUser p ORDER BY p.id DESC")
    List<RegisteredUser> findAllDesc();
}
