package bookclub.bookclubspring.domain.personalinquiry;

import bookclub.bookclubspring.domain.review.Review;
import bookclub.bookclubspring.web.DeveloperInquiryController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalInquiryRepository extends JpaRepository<PersonalInquiry, Long> {

    @Query("SELECT p From PersonalInquiry p ORDER BY p.id DESC")
    List<PersonalInquiry> findAllDesc();
}
